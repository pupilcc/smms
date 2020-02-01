package com.pupilcc.smms.base.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 基础数据类型 DTO 对象（List Data）
 * @param <T>
 * @author pupilcc
 */
@Data
public class BaseListDataDTO<T> {
    /**
     * Request status
     */
    private Boolean success;

    /**
     * Request status code
     */
    private String code;

    /**
     * Message
     */
    private String message;

    /**
     * data
     */
    private List<T> data;

    /**
     * Request ID
     */
    @JSONField(name = "RequestId")
    private String requestId;
}
