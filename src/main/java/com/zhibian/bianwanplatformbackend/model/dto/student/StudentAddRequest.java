package com.zhibian.bianwanplatformbackend.model.dto.student;

import lombok.Data;

import java.io.Serializable;
@Data
public class StudentAddRequest implements Serializable {
    private String name;
    private String parentPhone;
    private String elementarySchool;
}
