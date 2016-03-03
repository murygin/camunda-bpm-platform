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
package org.camunda.bpm.engine.impl.batch;

import org.camunda.bpm.engine.impl.jobexecutor.JobHandler;

/**
 * @author Thorben Lindhauer
 *
 */
public interface BatchHandler<T> extends JobHandler {

  byte[] writeConfiguration(T configuration);

  T readConfiguration(byte[] serializedConfiguration);

  /**
   * Returns true if more jobs need to be created to complete the batch
   */
  boolean createJobs(BatchEntity batch, int numJobsPerSeedInvocation, int numInvocationsPerJobs);
}
