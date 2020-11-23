package com.github.pupilcc.smms.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;

/**
 * JSON 工具类
 * @author pupilcc
 */
public class JsonUtils {

    /**
     * json 转换成对象
     * @param jsonStr json字符串
     * @param obj 对象
     * @return Object
     */
    public static <T> T jsonToObj(T obj, String jsonStr) {
        if (ObjectUtils.isEmpty(jsonStr)) {
            return obj;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            obj = mapper.readerFor(obj.getClass()).readValue(jsonStr);
        } catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }


    /**
     * json 转换成对象
     * @param valueTypeRef 对象
     * @param jsonStr json字符串
     * @return Object
     */
    public static <T> T jsonToObj(TypeReference<T> valueTypeRef, String jsonStr) {
        if (ObjectUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转换成 json
     * @param obj 对象
     * @return json字符串
     */
    public static String objToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
