package org.yun.heartcheck.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.yun.heartcheck.model.Url;
import org.yun.heartcheck.repository.UrlRepository;
import org.yun.heartcheck.service.UrlService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UrlServiceImpl implements UrlService {

    @Resource
    UrlRepository repository;

    @Override
    @Async
    @CachePut(cacheNames = "url", key = "#result.id")
    public Url save(Url model) {
        // todo 将url保存或更新
        return repository.save(model);
    }

    @Override
    @Async
    @CacheEvict(cacheNames = "url", key = "#id")
    public void deleteById(String id) {
        // todo 通过id删除url记录
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> idList) {
        // todo 通过条件删除url记录，或者删除全部记录
        idList.stream().map(String::toString).forEach(this::deleteById);
    }

    @Override
    @Cacheable(cacheNames = "url", key = "#id", unless = "#result == null")
    public Url getModel(String id) {
        // todo 通过id获得一条url记录
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Url> get(List<String> idList) {
        idList.stream().map(String::toString).forEach(getModel());
        // todo 通过条件获取url记录，或者获得全部url记录
        return StreamSupport.stream(repository.findAllById(idList).spliterator(), false)
                .collect(Collectors.toList());
    }
}
