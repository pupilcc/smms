package com.github.pupilcc.smms.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pupilcc.smms.dto.ImageDataDTO;
import com.github.pupilcc.smms.dto.ProfileDataDTO;
import com.github.pupilcc.smms.properties.SmmsConstants;
import com.github.pupilcc.smms.response.BaseDataResponse;
import com.github.pupilcc.smms.response.BaseListDataResponse;
import com.github.pupilcc.smms.response.BaseResponse;
import com.github.pupilcc.smms.util.JsonUtils;
import lombok.AllArgsConstructor;
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
 * @author pupilcc
 * @since 2022-07-03
 */
@Service
@AllArgsConstructor
public class SmmsServiceImpl implements SmmsService{
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    private HttpEntity getHttpEntity() {
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        return request;
    }

    @Override
    public BaseDataResponse<ProfileDataDTO> getProfile() {
        HttpEntity request = getHttpEntity();

        ResponseEntity<String> response = restTemplate.exchange(
                SmmsConstants.URL_API + SmmsConstants.URL_GET_PROFILE,
                HttpMethod.POST,
                request,
                String.class
        );

        return JsonUtils.jsonToObj(new TypeReference<BaseDataResponse<ProfileDataDTO>>() {}, response.getBody());
    }

    @Override
    public BaseListDataResponse<ImageDataDTO> uploadHistory() {
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                SmmsConstants.URL_API + SmmsConstants.URL_UPLOAD_HISTORY,
                HttpMethod.GET,
                request,
                String.class
        );

        return JsonUtils.jsonToObj(new TypeReference<BaseListDataResponse<ImageDataDTO>>() {}, response.getBody());
    }


    public BaseDataResponse<ImageDataDTO> uploadImage(MultipartFile file, String format) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>(2);
        paramMap.add("smfile", file.getResource());
        paramMap.add("format", format);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(paramMap);

        ResponseEntity<String> response = restTemplate.exchange(
                SmmsConstants.URL_API + SmmsConstants.URL_UPLOAD_IMAGE,
                HttpMethod.POST,
                request,
                String.class
        );

        return JsonUtils.jsonToObj(new TypeReference<BaseDataResponse<ImageDataDTO>>() {}, response.getBody());
    }

    @Override
    public BaseResponse deleteImage(String hash, String format) {
        String url = SmmsConstants.URL_API + SmmsConstants.URL_DELETE +
                "/" + hash + "?format=" + format;
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null);
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return JsonUtils.jsonToObj(new BaseResponse(), response.getBody());
    }

}
