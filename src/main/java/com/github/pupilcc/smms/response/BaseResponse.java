package com.github.pupilcc.smms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 基础响应对象
 *
 * @author pupilcc
 */
@Data
public class BaseResponse {
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
    @JsonProperty("RequestId")
    private String requestId;
}
