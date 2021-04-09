package org.yun.heartcheck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yun.heartcheck.model.EventLog;
import org.yun.heartcheck.repository.EventLogRepository;
import org.yun.heartcheck.service.EventLogService;

@Async
@Service
public class EventLogServiceImpl implements EventLogService {

    @Autowired
    private EventLogRepository repository;

    @Override
    public void save(String event_name, String event_message, String remark, String time) {
        EventLog eventLog = new EventLog();
        eventLog.setEvent_name(event_name);
        eventLog.setEvent_message(event_message);
        eventLog.setRemark(remark);
        eventLog.setTime(time);
        repository.save(eventLog);
    }
}
