package com.pupilcc.smms.user.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.pupilcc.smms.base.dto.BaseDataDTO;
import com.pupilcc.smms.properties.SmmsConstants;
import com.pupilcc.smms.properties.SmmsProperties;
import com.pupilcc.smms.user.dto.ProfileDataDTO;
import com.pupilcc.smms.util.JsonUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * User 模块的业务处理
 * @author pupilcc
 */
@Service
public class UserService {
    private final SmmsProperties properties;
    private final RestTemplate restTemplate;

    public UserService(SmmsProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    /**
     * Get User Profile
     * @return Profile DTO 对象
     */
    public BaseDataDTO<ProfileDataDTO> getProfile() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBasicAuth(properties.getToken());
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);

        String response = restTemplate.postForObject(
                SmmsConstants.URL_API + SmmsConstants.URL_GET_PROFILE, request, String.class);

        return JsonUtils.jsonToObj(new TypeReference<BaseDataDTO<ProfileDataDTO>>(){}, response);
    }
}
