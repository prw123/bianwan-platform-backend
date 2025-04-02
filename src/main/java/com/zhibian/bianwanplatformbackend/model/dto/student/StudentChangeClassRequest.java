package com.zhibian.bianwanplatformbackend.model.dto.student;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentChangeClassRequest implements Serializable {
    private String name;
    private Long classId;
}
