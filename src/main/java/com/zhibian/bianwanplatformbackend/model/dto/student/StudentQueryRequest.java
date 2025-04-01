package com.zhibian.bianwanplatformbackend.model.dto.student;

import lombok.Data;

@Data
public class StudentQueryRequest {
    private String elementarySchool;
    private String parentPhone;
    private String name;
}
