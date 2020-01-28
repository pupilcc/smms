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
     * smms 帐号
     */
    private String username = "";

    /**
     * smms 密码
     */
    private String password = "";
}
