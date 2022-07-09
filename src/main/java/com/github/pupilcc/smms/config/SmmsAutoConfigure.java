package com.github.pupilcc.smms.config;

import cn.hutool.http.Header;
import com.github.pupilcc.smms.domain.SmmsService;
import com.github.pupilcc.smms.domain.SmmsServiceImpl;
import com.github.pupilcc.smms.properties.SmmsProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> headers = headers(smmsProperties);
        return new SmmsServiceImpl(headers);
    }

    @Bean
    public Map<String, String> headers(SmmsProperties smmsProperties) {
        Map<String, String> headers = new HashMap<>(3);
        headers.put(Header.CONTENT_TYPE.getValue(), "multipart/form-data");
        headers.put(Header.AUTHORIZATION.getValue(), smmsProperties.getToken());
        headers.put(
                Header.USER_AGENT.getValue(),
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36"
        );
        return headers;
    }
}
