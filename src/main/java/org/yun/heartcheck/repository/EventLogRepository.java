package org.yun.heartcheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.yun.heartcheck.model.EventLog;

public interface EventLogRepository extends CrudRepository<EventLog, String> {
}
