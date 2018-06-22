package com.qianlq.attendance.service;

import com.qianlq.attendance.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-03-23 下午3:33
 * mail: 1242202279@qq.com
 */

public interface TeacherService {

    /**
     * 根据账号查询详细信息
     *
     * @param account 教工号
     * @return BaseResult
     */
    BaseResult getTeaDetailInfo(String account);

    /**
     * 根据密码账号登录
     *
     * @param account  教工号
     * @param password 密码
     * @return BaseResult
     */
    BaseResult doLogin(String account, String password);

    /**
     * 更新个人基本信息
     *
     * @param account  教工号
     * @param password 密码
     * @param name     姓名
     * @param phone    手机号码
     * @param email    电子邮箱
     * @return BaseResult
     */
    BaseResult updateTeaBaseInfo(String account, String password, String name, String phone, String email);

    /**
     * 查询教师课表
     *
     * @param account 教工号
     * @return BaseResult
     */
    BaseResult getTeaSchedule(String account);

    /**
     * 查询课程上课学生
     *
     * @param tabNo 课程表编号
     * @return BaseResult
     */
    BaseResult getCouStudent(String tabNo);

    /**
     * 发布签到
     *
     * @param account   教师编号
     * @param tabNo     课程表编号
     * @param place     签到地点
     * @param longitude 定位经度
     * @param latitude  定位维度
     * @param time      发布时间
     * @param timeout   超时时间
     * @param remark    备注
     * @return BaseResult
     */
    BaseResult issueSignIn(String account, String tabNo, String place, String longitude, String latitude, String time, String timeout, String remark);

    /**
     * 查询历史记录
     *
     * @param account 教师编号
     * @param time    时间
     * @return BaseResult
     */
    BaseResult getHistory(String account, String time);

    /**
     * 查询学生签到情况
     *
     * @param attNo 签到编号
     * @return BaseResult
     */
    BaseResult getResult(String attNo);

    /**
     * 取消最近时间的签到
     *
     * @param attNo   签到编号
     * @return BaseResult
     */
    BaseResult cancelSignIn(String attNo);

    /**
     * 查询课程学期汇总情况
     *
     * @param focus 课程表编号(包括同一节课)
     * @return BaseResult
     */
    BaseResult getSummary(String focus);
}
