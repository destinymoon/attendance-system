package com.qianlq.attendance.service;

import com.qianlq.attendance.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-03-19 下午2:54
 * mail: 1242202279@qq.com
 */

public interface StudentService {

    /**
     * 根据账号查询详细信息
     *
     * @param account 学号
     * @return BaseResult
     */
    BaseResult getStuDetailInfo(String account);

    /**
     * 根据账号密码登录
     *
     * @param account  学号
     * @param password 密码
     * @return BaseResult
     */
    BaseResult doLogin(String account, String password);

    /**
     * 更新学生基本信息
     *
     * @param account  学号
     * @param password 密码
     * @param name     姓名
     * @param phone    手机号码
     * @param email    电子邮箱
     * @return BaseResult
     */
    BaseResult updateStuBaseInfo(String account, String password, String name, String phone, String email);

    /**
     * 查询学生课表
     *
     * @param account 学号
     * @return BaseResult
     */
    BaseResult getStuSchedule(String account);

    /**
     * 查询未签到记录
     *
     * @param account 学号
     * @return BaseResult
     */
    BaseResult getLastRecord(String account);

    /**
     * 签到
     *
     * @param account 学号
     * @param attNo   具体课程
     * @param place   定位地点
     * @return BaseResult
     */
    BaseResult doSignIn(String account, String attNo, String place);

    /**
     * 请假
     *
     * @param account 学号
     * @param attNo   具体课程
     * @param remark  备注
     * @return BaseResult
     */
    BaseResult applyLeave(String account, String attNo, String remark);

    /**
     * 查询历史签到情况
     *
     * @param account 学号
     * @param time    时间
     * @return BaseResult
     */
    BaseResult getHistory(String account, String time);
}
