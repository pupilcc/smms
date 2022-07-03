package com.github.pupilcc.smms.config;

import com.github.pupilcc.smms.domain.SmmsService;
import com.github.pupilcc.smms.domain.SmmsServiceImpl;
import com.github.pupilcc.smms.properties.SmmsProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author pupilcc
 * @since 2022-07-03
 */
@Configuration
@ConditionalOnClass(SmmsService.class)
@EnableConfigurationProperties(SmmsProperties.class)
public class SmmsAutoConfigure {
    @Bean
    public SmmsService smmsService(SmmsProperties smmsProperties) {
        HttpHeaders headers = headers(smmsProperties);
        return new SmmsServiceImpl(restTemplate(), headers);
    }

    @Bean
    public HttpHeaders headers(SmmsProperties smmsProperties) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBasicAuth(smmsProperties.getToken());
        headers.add(
                "user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"
        );
        return headers;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
