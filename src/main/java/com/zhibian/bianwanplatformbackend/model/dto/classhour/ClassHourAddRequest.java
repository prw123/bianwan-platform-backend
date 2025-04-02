package com.zhibian.bianwanplatformbackend.model.dto.classhour;

import lombok.Getter;

@Getter
public class ClassHourAddRequest {

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 教师ID
     */
    private Long teacherId;
}
