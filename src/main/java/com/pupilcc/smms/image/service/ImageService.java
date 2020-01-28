package com.pupilcc.smms.image.service;

import com.alibaba.fastjson.JSON;
import com.pupilcc.smms.base.dto.BaseDTO;
import com.pupilcc.smms.properties.SmmsConstants;
import com.pupilcc.smms.image.dto.UploadHistoryDTO;
import com.pupilcc.smms.image.dto.UploadImageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 * Image 模块的接口
 * @author pupilcc
 */
@Service
public class ImageService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final HttpHeaders headers;
    private final RestTemplate restTemplate;

    public ImageService(HttpHeaders headers, RestTemplate restTemplate) {
        this.headers = headers;
        this.restTemplate = restTemplate;
    }

    /**
     * 图片上传
     * https://doc.sm.ms/#api-Image-Upload
     * @param file 图片文件
     * @param format Return Type: json or xml, the default value is json
     * @return Upload Image DTO
     */
    public UploadImageDTO uploadImage(MultipartFile file, String format) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>(2);
        paramMap.add("smfile", file.getResource());
        paramMap.add("format", format);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(paramMap, headers);

        String response = restTemplate.postForObject(
                SmmsConstants.URL_API + SmmsConstants.URL_UPLOAD_IMAGE, request, String.class);

        return JSON.parseObject(response, UploadImageDTO.class);
    }

    /**
     * 查询上传的历史记录
     * https://doc.sm.ms/#api-Image-Upload_History
     * @return Upload History DTO
     */
    public UploadHistoryDTO uploadHistory() {
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                SmmsConstants.URL_API + SmmsConstants.URL_UPLOAD_HISTORY,
                HttpMethod.GET, request, String.class);
        return JSON.parseObject(response.getBody(), UploadHistoryDTO.class);
    }

    /**
     * 删除图片
     * https://doc.sm.ms/#api-Image-Deletion
     * @param hash 图片的 hash
     * @param format Return Type: json or xml, the default value is json
     * @return BaseDTO 对象
     */
    public BaseDTO deleteImage(String hash, String format) {
        String url = SmmsConstants.URL_API + SmmsConstants.URL_DELETE + "/" + hash + "?format=" + format;
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return JSON.parseObject(response.getBody(), BaseDTO.class);
    }
}
