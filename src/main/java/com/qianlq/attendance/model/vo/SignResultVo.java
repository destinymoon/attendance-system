package com.qianlq.attendance.model.vo;

import lombok.*;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-04-17 下午5:24
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
public class SignResultVo {

    private List<ResultVo> signResult;

    public SignResultVo(List<ResultVo> signResult) {
        this.signResult = signResult;
    }
}
