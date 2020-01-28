package com.pupilcc.smms.user.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 上传图片接口中的 data 参数
 * @author pupilcc
 */
@Data
public class UploadImageDataDTO {
    /**
     * Width
     */
    private Number width;

    /**
     * Height
     */
    private Number height;

    /**
     * Filename
     */
    private String filename;

    /**
     * Store name
     */
    @JSONField(name = "storename")
    private String storeName;

    /**
     * Image Size
     */
    private Number size;

    /**
     * Image Path
     */
    private String path;

    /**
     * Image Deletion HASH
     */
    private String hash;

    /**
     * Image URL
     */
    private String url;

    /**
     * Image Deletion Link
     */
    private String delete;

    /**
     * Image Page Link
     */
    private String page;
}