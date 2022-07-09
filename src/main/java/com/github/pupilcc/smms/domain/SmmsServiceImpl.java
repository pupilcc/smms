package com.github.pupilcc.smms.domain;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.pupilcc.smms.dto.ImageDataDTO;
import com.github.pupilcc.smms.dto.ProfileDataDTO;
import com.github.pupilcc.smms.properties.SmmsConstants;
import com.github.pupilcc.smms.response.BaseDataResponse;
import com.github.pupilcc.smms.response.BaseListDataResponse;
import com.github.pupilcc.smms.response.BaseResponse;
import com.github.pupilcc.smms.util.JsonUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pupilcc
 * @since 2022-07-03
 */
@Service
@AllArgsConstructor
public class SmmsServiceImpl implements SmmsService{
    private Map<String, String> headers;

    @Override
    public BaseDataResponse<ProfileDataDTO> getProfile() {
        String response = postRequest(
                SmmsConstants.URL_API + SmmsConstants.URL_GET_PROFILE,
                headers,
                new HashMap<>(0)
        );

        return JsonUtils.jsonToObj(new TypeReference<BaseDataResponse<ProfileDataDTO>>() {}, response);
    }

    @Override
    public BaseListDataResponse<ImageDataDTO> uploadHistory() {
        String response = getRequest(
                SmmsConstants.URL_API + SmmsConstants.URL_UPLOAD_HISTORY,
                headers
        );

        return JsonUtils.jsonToObj(new TypeReference<BaseListDataResponse<ImageDataDTO>>() {}, response);
    }

    @Override
    public BaseDataResponse<ImageDataDTO> uploadImage(File file, String format) {
        Map<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("smfile", file);
        paramMap.put("format", format);

        String response = postRequest(
                SmmsConstants.URL_API + SmmsConstants.URL_UPLOAD_IMAGE,
                headers,
                paramMap
        );

        return JsonUtils.jsonToObj(new TypeReference<BaseDataResponse<ImageDataDTO>>() {}, response);
    }

    @Override
    public BaseResponse deleteImage(String hash, String format) {
        String url = SmmsConstants.URL_API + SmmsConstants.URL_DELETE +
                "/" + hash + "?format=" + format;
        String response = getRequest(url, headers);

        return JsonUtils.jsonToObj(new BaseResponse(), response);
    }

    /**
     * post 请求
     *
     * @param url 请求 URL
     * @param headers 请求头
     * @param paramMap 请求参数
     * @return 响应信息
     */
    private String postRequest(String url, Map<String, String> headers, Map<String, Object> paramMap) {
        String result = HttpRequest.post(url)
                .header(Header.AUTHORIZATION, headers.get(Header.AUTHORIZATION.getValue()))
                .header(Header.CONTENT_TYPE, headers.get(Header.CONTENT_TYPE.getValue()))
                .header(Header.USER_AGENT, headers.get(Header.USER_AGENT.getValue()))
                .form(paramMap)
                .timeout(20000)
                .execute().body();
        return result;
    }

    /**
     * get 请求
     *
     * @param url 请求 URL
     * @param headers 请求头
     * @return 响应信息
     */
    private String getRequest(String url, Map<String, String> headers) {
        String result = HttpRequest.get(url)
                .header(Header.AUTHORIZATION, headers.get(Header.AUTHORIZATION.getValue()))
                .header(Header.CONTENT_TYPE, headers.get(Header.CONTENT_TYPE.getValue()))
                .header(Header.USER_AGENT, headers.get(Header.USER_AGENT.getValue()))
                .timeout(20000)
                .execute().body();
        return result;
    }
}
