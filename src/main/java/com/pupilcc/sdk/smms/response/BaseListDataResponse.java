package com.pupilcc.sdk.smms.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 基础响应数据对象（List Data）
 *
 * @param <T>
 * @author pupilcc
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseListDataResponse<T> extends BaseResponse {
    /**
     * data
     */
    private List<T> data;
}
