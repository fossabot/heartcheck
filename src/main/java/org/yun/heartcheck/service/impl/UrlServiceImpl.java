package org.yun.heartcheck.service.impl;

import org.yun.heartcheck.model.Url;
import org.yun.heartcheck.service.UrlService;

import java.util.List;
import java.util.Map;

public class UrlServiceImpl implements UrlService {

    @Override
    public boolean save(Url model) {
        // todo 将url保存或更新
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        // todo 通过id删除url记录
        return false;
    }

    @Override
    public boolean deleteAll(Map<String, String> map) {
        // todo 通过条件删除url记录，或者删除全部记录
        return false;
    }

    @Override
    public Url getModel(String id) {
        // todo 通过id获得一条url记录
        return null;
    }

    @Override
    public List<Url> get(Map<String, String> map) {
        // todo 通过条件获取url记录，或者获得全部url记录
        return null;
    }
}
