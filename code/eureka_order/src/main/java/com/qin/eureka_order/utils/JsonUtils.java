package com.qin.eureka_order.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/* author:Qinzijing
*  date: 2020/2/4
*  description:JSON 工具类
*/
public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /*
    * json字符串转化为JsonNode 对象的方法
    * */
    public static JsonNode str2JsonNode(String str){
        try {
            return objectMapper.readTree(str);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
