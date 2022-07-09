package com.pupilcc.sdk.smms.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础响应数据对象
 *
 * @param <T>
 * @author pupilcc
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDataResponse<T> extends BaseResponse {
    /**
     * data
     */
    private T data;
}
