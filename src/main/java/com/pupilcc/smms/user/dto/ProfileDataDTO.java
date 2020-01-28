package com.pupilcc.smms.user.dto;

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
    private String groupExpire;

    /**
     * Email Verification（0 for not verified， 1 for verified）
     */
    private String emailVerified;

    /**
     * Disk Usage
     */
    private String diskUsage;

    /**
     * Disk RAW Usage（Byte）
     */
    private String diskUsageRaw;

    /**
     * Disk Limit
     */
    private String diskLimit;

    /**
     * Disk RAW Limit（Byte）
     */
    private String diskLimitRaw;
}
