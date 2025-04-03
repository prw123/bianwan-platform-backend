package com.zhibian.bianwanplatformbackend.model.dto.aclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassAddRequest implements Serializable {
    /**
     * 班级名称
     */
    private String className;
    /**
     * 老师id
     */
    private String teacherName;
}
