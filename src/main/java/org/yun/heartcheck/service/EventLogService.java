package org.yun.heartcheck.service;

public interface EventLogService {

    void save(String event_name,String event_message,String remark,String time);
}
