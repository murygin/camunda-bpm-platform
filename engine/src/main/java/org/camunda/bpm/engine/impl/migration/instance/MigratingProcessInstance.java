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
package org.camunda.bpm.engine.impl.migration.instance;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.impl.ProcessEngineLogger;
import org.camunda.bpm.engine.impl.migration.MigrationLogger;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.migration.MigrationInstruction;
import org.camunda.bpm.engine.runtime.ActivityInstance;

/**
 * @author Thorben Lindhauer
 *
 */
public class MigratingProcessInstance {

  protected static final MigrationLogger LOGGER = ProcessEngineLogger.MIGRATION_LOGGER;

  protected String processInstanceId;
  protected Map<String, MigratingActivityInstance> migratingActivityInstances;

  public MigratingProcessInstance(String processInstanceId) {
    this.processInstanceId = processInstanceId;
    this.migratingActivityInstances = new HashMap<String, MigratingActivityInstance>();
  }

  public Collection<MigratingActivityInstance> getMigratingActivityInstances() {
    return migratingActivityInstances.values();
  }

  public MigratingActivityInstance getMigratingInstance(String activityInstanceId) {
    return migratingActivityInstances.get(activityInstanceId);
  }

  public String getProcessInstanceId() {
    return processInstanceId;
  }

  public MigratingActivityInstance addActivityInstance(
      MigrationInstruction migrationInstruction,
      ActivityInstance activityInstance,
      ScopeImpl sourceScope,
      ScopeImpl targetScope,
      ExecutionEntity scopeExecution) {

    MigratingActivityInstance migratingActivityInstance = new MigratingActivityInstance(
        activityInstance,
        migrationInstruction,
        sourceScope,
        targetScope,
        scopeExecution);

    migratingActivityInstances.put(activityInstance.getId(), migratingActivityInstance);

    return migratingActivityInstance;
  }

}
