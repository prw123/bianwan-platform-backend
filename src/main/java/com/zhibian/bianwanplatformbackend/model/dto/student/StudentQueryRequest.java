package com.zhibian.bianwanplatformbackend.model.dto.student;

import com.zhibian.bianwanplatformbackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentQueryRequest extends PageRequest implements Serializable {
    private String elementarySchool;
    private String parentPhone;
    private String name;

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
}
