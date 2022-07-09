package com.pupilcc.sdk.smms.domain;

import com.pupilcc.sdk.smms.dto.ImageDataDTO;
import com.pupilcc.sdk.smms.dto.ProfileDataDTO;
import com.pupilcc.sdk.smms.response.BaseDataResponse;
import com.pupilcc.sdk.smms.response.BaseListDataResponse;
import com.pupilcc.sdk.smms.response.BaseResponse;

import java.io.File;

/**
 * @author pupilcc
 * @since 2022-07-03
 */
public interface SmmsService {
    /**
     * 获取用户信息
     * https://doc.sm.ms/#api-User-Get_Profile
     *
     * @return
     */
    BaseDataResponse<ProfileDataDTO> getProfile();

    /**
     * 查询上传的历史记录
     * https://doc.sm.ms/#api-Image-Upload_History
     *
     * @return Upload History DTO
     */
    BaseListDataResponse<ImageDataDTO> uploadHistory();

    /**
     * 删除图片
     * https://doc.sm.ms/#api-Image-Deletion
     *
     * @param hash   image hash
     * @param format Return Type: json or xml, the default value is json
     * @return BaseResponse
     */
    BaseResponse deleteImage(String hash, String format);

    /**
     * 图片上传
     * https://doc.sm.ms/#api-Image-Upload
     *
     * @param file   图片文件
     * @param format Return Type: json or xml, the default value is json
     * @return Upload Image DTO
     */
    BaseDataResponse<ImageDataDTO> uploadImage(File file, String format);
}
