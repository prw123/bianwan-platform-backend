package com.zhibian.bianwanplatformbackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 班级
 * @TableName class
 */
@Data
@TableName(value ="class")
public class Class {
    /**
     * 班级ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 是否开课（0-未开课，1-已开课）
     */
    private Integer isActive;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除（0-未删除，1-已删除）
     */
    private Integer isDelete;

    /**
     * 老师id
     */
    private String teacherName;
    /**
     * 学生列表
     */
    @TableField(exist = false)
    private List<Student> students;

}