package org.yun.heartcheck.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yun.heartcheck.model.Status;
import org.yun.heartcheck.model.Task;
import org.yun.heartcheck.repository.TaskRepository;
import org.yun.heartcheck.service.TaskService;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    TaskRepository repository;

    @Async
    @Override
    public Task createTask(Task model) {
        return repository.save(model);
    }

    @Async
    @Override
    public boolean deleteTask(Task model) {
        return false;
    }

    @Async
    @Override
    public Task updateTask(Task model) {
        return repository.save(model);
    }

    @Override
    public Task getTask(String id) {
        return repository.findById(id).orElse(null);
    }

    @Async
    @Override
    public boolean startTask(String id) {
        Optional<Task> model = repository.findById(id);
        if (model.isPresent()) {
            model.get().setStatus(Status.RUN);
            repository.save(model.get());
            // todo 添加定时任务的处理
            return true;
        }
        return false;
    }

    @Async
    @Override
    public boolean stopTask(String id) {
        Optional<Task> model = repository.findById(id);
        if (model.isPresent()) {
            model.get().setStatus(Status.STOP);
            repository.save(model.get());
            // todo 添加定时任务的处理
            return true;
        }
        return false;
    }
}
