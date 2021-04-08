package org.yun.heartcheck.service;

import org.yun.heartcheck.model.Url;

import java.util.List;
import java.util.Map;

public interface UrlService {

    /**
     * @param model
     * @return boolean
     * @author wanglianbo a317526763@gmail.com
     * @description 新增或保存一条新的url记录
     * @date 2021/4/8 19:47
     **/
    boolean save(Url model);

    /**
     * @param id
     * @return boolean
     * @author wanglianbo a317526763@gmail.com
     * @description 通过id删除一条url记录
     * @date 2021/4/8 19:47
     **/
    boolean deleteById(String id);

    /**
     * @param map
     * @return boolean
     * @author wanglianbo a317526763@gmail.com
     * @description 通过某些条件删除url记录，或者将所有url记录删除
     * @date 2021/4/8 19:48
     **/
    boolean deleteAll(Map<String, String> map);

    /**
     * @param id
     * @return org.yun.heartcheck.model.Url
     * @author wanglianbo a317526763@gmail.com
     * @description 通过id获取一条url记录
     * @date 2021/4/8 19:54
     **/
    Url getModel(String id);

    /**
     * @param map
     * @return java.util.List<org.yun.heartcheck.model.Url>
     * @author wanglianbo a317526763@gmail.com
     * @description 通过条件获取url记录，或者获取所有url记录
     * @date 2021/4/8 19:54
     **/
    List<Url> get(Map<String, String> map);

    /**
     * @author wanglianbo a317526763@gmail.com
     * @description 关闭定时任务
     * @date 2021/4/8 20:14
     * @param
     * @return boolean
     **/
    boolean closeTask(String id);

    /**
     * @author wanglianbo a317526763@gmail.com
     * @description 通过条件关闭定时任务
     * @date 2021/4/8 20:18
     * @param map
     * @return boolean
     **/
    boolean closeTask(Map<String,String> map);

    /**
     * @author wanglianbo a317526763@gmail.com
     * @description 开始定时任务
     * @date 2021/4/8 20:17
     * @param id
     * @return boolean
     **/
    boolean openTask(String id);

    /**
     * @author wanglianbo a317526763@gmail.com
     * @description 通过条件开始定时任务
     * @date 2021/4/8 20:19
     * @param map
     * @return boolean
     **/
    boolean openTask(Map<String,String> map);
}
