package org.yun.heartcheck.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yun.heartcheck.model.Url;
import org.yun.heartcheck.repository.UrlRepository;
import org.yun.heartcheck.service.UrlService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UrlServiceImpl implements UrlService {

    @Resource
    UrlRepository repository;

    @Override
    @Async
    public Url save(Url model) {
        // todo 将url保存或更新
        return repository.save(model);
    }

    @Override
    @Async
    public void deleteById(String id) {
        // todo 通过id删除url记录
        repository.deleteById(id);
    }

    @Override
    @Async
    public void deleteAll(List<String> idList) {
        // todo 通过条件删除url记录，或者删除全部记录
        repository.deleteUrlByIdIn(idList);
    }

    @Override
    public Url getModel(String id) {
        // todo 通过id获得一条url记录
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Url> get(List<String> idList) {
        // todo 通过条件获取url记录，或者获得全部url记录
        return StreamSupport.stream(repository.findAllById(idList).spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean closeTask(String id) {
//        Quartz.removeJob();
        boolean success = repository.updateTask(id, "stop") > 0 ? true : false;
        return success ? true : false;
    }

    @Override
    public boolean closeTask(Map<String, String> map) {
//        repository.updateTask(id,"stop");
        return false;
    }

    @Override
    public boolean openTask(String id) {
        repository.updateTask(id, "run");
        return false;
    }

    @Override
    public boolean openTask(Map<String, String> map) {
//        repository.updateTask(id,"run");
        return false;
    }
}
