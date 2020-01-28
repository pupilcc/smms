package com.pupilcc.smms.base.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 基础 DTO 对象
 * @author pupilcc
 */
@Data
public class BaseDTO {
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
     * Request ID
     */
    @JSONField(name = "RequestId")
    private String requestId;
}
