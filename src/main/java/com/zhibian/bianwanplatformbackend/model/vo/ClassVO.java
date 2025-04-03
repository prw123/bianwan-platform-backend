package com.zhibian.bianwanplatformbackend.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ClassVO implements Serializable {

    /**
     * 班级ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 是否开班（0-未开班，1-已开班）
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
     * 老师姓名
     */
    private String teacherName;

    private List<Student> students;


}
