package com.github.pupilcc.smms.base.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 基础数据类型 DTO 对象
 * @param <T>
 * @author pupilcc
 */
@Data
public class BaseDataDTO<T> {
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
    private T data;

    /**
     * Request ID
     */
    @JsonProperty("RequestId")
    private String requestId;
}
