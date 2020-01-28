package com.pupilcc.smms.user.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Get API Token DTO
 * @author pupilcc
 */
@Data
public class TokenDTO {
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
    private TokenDataDTO data;

    /**
     * Request ID
     */
    @JSONField(name = "RequestId")
    private String requestId;
}
