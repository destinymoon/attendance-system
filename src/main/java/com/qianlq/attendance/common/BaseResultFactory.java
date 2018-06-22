package com.qianlq.attendance.common;

import com.qianlq.attendance.common.constant.Result;
import lombok.SneakyThrows;

/**
 * @author qianliqing
 * @date 2018-03-23 下午3:54
 * mail 1242202279@qq.com
 *
 * BaseResult工程方法
 */

@SuppressWarnings("unchecked")
public final class BaseResultFactory {

    /**
     * 构建成功返回的数据
     *
     * @param data
     * @return
     */
    public static BaseResult createSuccessResult(Object data) {
        BaseResult result = new BaseResult(Result.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 成功但不返回的数据
     *
     * @return
     */
    public static BaseResult createSuccessResult() {
        return new BaseResult(Result.SUCCESS);
    }

    /**
     * 构建失败返回的数据
     *
     * @return
     */
    public static BaseResult createFailedResult() {
        return new BaseResult(Result.FAILED);
    }
}
