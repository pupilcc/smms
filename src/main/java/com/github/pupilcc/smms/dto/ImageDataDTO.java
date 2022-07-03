package com.github.pupilcc.smms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 图片数据 DTO
 *
 * @author pupilcc
 */
@Data
public class ImageDataDTO {
    /**
     * file_id
     */
    @JsonProperty("file_id")
    private Number fileId;

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
    @JsonProperty("storename")
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
