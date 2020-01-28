package com.pupilcc.smms.user.service;

import com.alibaba.fastjson.JSON;
import com.pupilcc.smms.properties.SmmsConstants;
import com.pupilcc.smms.properties.SmmsProperties;
import com.pupilcc.smms.user.dto.ProfileDTO;
import com.pupilcc.smms.user.dto.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * User 模块的业务处理
 * @author pupilcc
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final SmmsProperties properties;
    private final RestTemplate restTemplate;

    public UserService(SmmsProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }


    /**
     * Get API Token
     * @return Token DTO 对象
     */
    public TokenDTO getToken() {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>(2);
        paramMap.add("username", properties.getUsername());
        paramMap.add("password", properties.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(paramMap, headers);

        String response = restTemplate.postForObject(
                SmmsConstants.URL_API + SmmsConstants.URL_GET_TOKEN, request, String.class);

        return JSON.parseObject(response, TokenDTO.class);
    }

    /**
     * Get User Profile
     * @return Profile DTO 对象
     */
    public ProfileDTO getProfile() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBasicAuth(getToken().getData().getToken());
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);

        String response = restTemplate.postForObject(
                SmmsConstants.URL_API + SmmsConstants.URL_GET_PROFILE, request, String.class);
        return JSON.parseObject(response, ProfileDTO.class);
    }
}
