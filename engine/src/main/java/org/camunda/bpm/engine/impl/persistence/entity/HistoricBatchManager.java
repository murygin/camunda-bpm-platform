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
package org.camunda.bpm.engine.impl.persistence.entity;

import java.util.List;

import org.camunda.bpm.engine.batch.history.HistoricBatch;
import org.camunda.bpm.engine.impl.Page;
import org.camunda.bpm.engine.impl.batch.history.HistoricBatchEntity;
import org.camunda.bpm.engine.impl.batch.history.HistoricBatchQueryImpl;
import org.camunda.bpm.engine.impl.persistence.AbstractManager;

/**
 * @author Thorben Lindhauer
 *
 */
public class HistoricBatchManager extends AbstractManager {

  public long findBatchCountByQueryCriteria(HistoricBatchQueryImpl historicBatchQuery) {

    // TODO: authorization
    return (Long) getDbEntityManager().selectOne("selectHistoricBatchCountByQueryCriteria", historicBatchQuery);
  }

  public List<HistoricBatch> findBatchesByQueryCriteria(HistoricBatchQueryImpl historicBatchQuery, Page page) {
    return getDbEntityManager().selectList("selectHistoricBatchesByQueryCriteria", historicBatchQuery, page);
  }

  public HistoricBatchEntity findHistoricBatchById(String batchId) {
    return (HistoricBatchEntity) getDbEntityManager().selectOne("findHistoricBatchById", batchId);
  }

  public void deleteHistoricBatchById(String id) {

    getDbEntityManager().delete(HistoricBatchEntity.class, "deleteHistoricBatchById", id);

  }


}
