package com.pupilcc.smms.config;

import com.pupilcc.smms.base.dto.BaseDataDTO;
import com.pupilcc.smms.properties.SmmsProperties;
import com.pupilcc.smms.user.dto.ProfileDataDTO;
import com.pupilcc.smms.user.dto.TokenDataDTO;
import com.pupilcc.smms.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * 配置中心
 * @author pupilcc
 */
@Configuration
public class Config {
    public final SmmsProperties smmsProperties;

    public Config(SmmsProperties smmsProperties) {
        this.smmsProperties = smmsProperties;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public BaseDataDTO<TokenDataDTO> tokenDTO() {
        return new UserService(smmsProperties, restTemplate()).getToken();
    }

    @Bean
    public BaseDataDTO<ProfileDataDTO> profileDTO() {
        return new UserService(smmsProperties, restTemplate()).getProfile();
    }

    @Bean
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBasicAuth(tokenDTO().getData().getToken());
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }
}
