package org.yun.heartcheck.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/http")
@Api(tags = "http心跳检测接口")
public class HttpRequestController {

    @ApiOperation(value = "获取全部http", response = JSON.class)
    @GetMapping("/get")
    public String get() {
        // todo 返回当前所有的url记录
        return "";
    }

    @PutMapping("/put")
    public String put(){
        // todo 将收到的url记录保存并进行轮询访问
        return "";
    }

    @DeleteMapping("/delete")
    public String delete(){
        // todo 将收到的url删除
        return "";
    }
}
