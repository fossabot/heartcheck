package org.yun.heartcheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yun.heartcheck.model.EventLog;

@Repository
public interface EventLogRepository extends CrudRepository<EventLog, String> {
}
