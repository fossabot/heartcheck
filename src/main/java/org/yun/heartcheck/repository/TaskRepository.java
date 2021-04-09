package org.yun.heartcheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.yun.heartcheck.model.Task;

public interface TaskRepository extends CrudRepository<Task, String> {
}
