package com.pupilcc.sdk.smms.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 配置文件自定义项
 *
 * @author pupilcc
 */
@Data
@ConfigurationProperties(prefix = "smms")
public class SmmsProperties {
    /**
     * API Token
     */
    private String token;
}
