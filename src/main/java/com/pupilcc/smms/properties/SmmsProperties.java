package com.pupilcc.smms.properties;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件自定义项
 * @author pupilcc
 */
@Data
@Configuration
public class SmmsProperties {
    /**
     * API Token
     */
    private String token = "";
}
