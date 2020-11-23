package com.github.pupilcc.smms.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 获取 Profile 接口中的 data 参数
 * @author pupilcc
 */
@Data
public class ProfileDataDTO {
    /**
     * Username
     */
    private String username;

    /**
     * Email
     */
    private String email;

    /**
     * User Group Name
     */
    private String role;

    /**
     * User Group Expire Date
     */
    @JsonProperty("group_expire")
    private String groupExpire;

    /**
     * Email Verification（0 for not verified， 1 for verified）
     */
    @JsonProperty("email_verified")
    private String emailVerified;

    /**
     * Disk Usage
     */
    @JsonProperty("disk_usage")
    private String diskUsage;

    /**
     * Disk RAW Usage（Byte）
     */
    @JsonProperty("disk_usage_raw")
    private String diskUsageRaw;

    /**
     * Disk Limit
     */
    @JsonProperty("disk_limit")
    private String diskLimit;

    /**
     * Disk RAW Limit（Byte）
     */
    @JsonProperty("disk_limit_raw")
    private String diskLimitRaw;
}
