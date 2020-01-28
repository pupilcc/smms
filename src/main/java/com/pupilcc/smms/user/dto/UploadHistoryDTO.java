package com.pupilcc.smms.user.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 上传历史记录接口的 DTO 对象
 * @author pupilcc
 */
@Data
public class UploadHistoryDTO {
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
    private List<UploadImageDataDTO> data;

    /**
     * Request ID
     */
    @JSONField(name = "RequestId")
    private String requestId;
}
