package com.github.pupilcc.smms.domain;

import com.github.pupilcc.smms.dto.ImageDataDTO;
import com.github.pupilcc.smms.dto.ProfileDataDTO;
import com.github.pupilcc.smms.response.BaseDataResponse;
import com.github.pupilcc.smms.response.BaseListDataResponse;
import com.github.pupilcc.smms.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

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
    BaseDataResponse<ImageDataDTO> uploadImage(MultipartFile file, String format);
}