/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.rest.dto.converter;

import org.camunda.bpm.engine.rest.exception.InvalidRequestException;
import org.camunda.bpm.engine.task.DelegationState;

import javax.ws.rs.core.Response.Status;

public class DelegationStateConverter extends JacksonAwareStringToTypeConverter<DelegationState> {

  @Override
  public DelegationState convertQueryParameterToType(String value) {
    try {
      return DelegationState.valueOf(value.toUpperCase());

    } catch (IllegalArgumentException e) {
      String message = "Valid values for property 'delegationState' are 'PENDING' or 'RESOLVED', but was '"+value+"'";
      throw new InvalidRequestException(Status.BAD_REQUEST, e, message);

    }
  }
}