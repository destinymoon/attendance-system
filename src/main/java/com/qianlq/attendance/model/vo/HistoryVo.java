package com.qianlq.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-04-22 上午11:19
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryVo {

    private List<TeaHistoryVo> teaHistoryVo;

    private List<StuHistoryVo> stuHistoryVo;
}

