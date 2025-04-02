package com.zhibian.bianwanplatformbackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

@Getter
public enum StudentStatusEnum {
    READING(0, "在读"),
    DROPPED(1, "请假"),
    SUSPENDED(2, "停课");

    private final int code;
    private final String desc;

    StudentStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static StudentStatusEnum getStudentEnumByValue(String value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        for (StudentStatusEnum stEnum : StudentStatusEnum.values()) {
            if (stEnum.desc.equals(value)) {
                return stEnum;
            }
        }
        return null;
    }
}
