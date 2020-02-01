package com.pupilcc.smms.image.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 图片数据 DTO
 * @author pupilcc
 */
@Data
public class ImageDataDTO {
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
