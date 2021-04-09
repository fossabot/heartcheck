package org.yun.heartcheck.service;

import org.yun.heartcheck.model.Task;

public interface TaskService {

    Task createTask(Task model);

    boolean deleteTask(Task model);

    Task updateTask(Task model);

    Task getTask(String id);

    boolean startTask(String id);

    boolean stopTask(String id);
}
