package org.yun.heartcheck.util;

import com.alibaba.fastjson.JSONObject;

import javax.persistence.AttributeConverter;

/**
 * @author wanglianbo a317526763@gmail.com
 * @description 解决jpa的map到数据库的问题
 * @date 2021/4/8 18:46
 **/
public class JpaConverterObjectJson implements AttributeConverter<Object, String> {
    @Override
    public String convertToDatabaseColumn(Object o) {
        return o == null ? null : JSONObject.toJSONString(o);
    }

    @Override
    public Object convertToEntityAttribute(String s) {
        return s == null ? null : JSONObject.parseObject(s);
    }
}