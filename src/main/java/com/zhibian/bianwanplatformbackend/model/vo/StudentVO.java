package com.zhibian.bianwanplatformbackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentVO implements Serializable {

    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 所属班级ID
     */
    private Long classId;

    /**
     * 所属小学
     */
    private String elementarySchool;

    /**
     * 家长手机号
     */
    private String parentPhone;

    /**
     * 近期荣誉
     */
    private String recentHonors;

    /**
     * 剩余课时
     */
    private Integer remainingHours;

    /**
     * 当前积分（可抵扣学费，需应用层保证≥0）
     */
    private Integer currentPoints;

    /**
     * 是否请假
     */
    private Integer isLeave;

    /**
     * 创建时间
     */
    private Date createTime;


}
