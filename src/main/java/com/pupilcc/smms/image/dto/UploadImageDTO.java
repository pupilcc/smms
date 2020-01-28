package com.pupilcc.smms.image.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 上传图片接口的 DTO 对象
 * @author pupilcc
 */
@Data
public class UploadImageDTO {
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
    private UploadImageDataDTO data;

    /**
     * Request ID
     */
    @JSONField(name = "RequestId")
    private String requestId;
}
