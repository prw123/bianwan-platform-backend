package com.zhibian.bianwanplatformbackend.controller;


import com.zhibian.bianwanplatformbackend.annotation.AuthCheck;
import com.zhibian.bianwanplatformbackend.common.BaseResponse;
import com.zhibian.bianwanplatformbackend.common.ResultUtils;
import com.zhibian.bianwanplatformbackend.constant.UserConstant;
import com.zhibian.bianwanplatformbackend.exception.ErrorCode;
import com.zhibian.bianwanplatformbackend.exception.ThrowUtils;
import com.zhibian.bianwanplatformbackend.model.dto.aclass.ClassAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentAddRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Class;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.zhibian.bianwanplatformbackend.service.ClassService;
import com.zhibian.bianwanplatformbackend.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Resource
    private ClassService classService;
    /**
     * 创建用户
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Long> addClass(@RequestBody ClassAddRequest classAddRequest) {
        ThrowUtils.throwIf(classAddRequest == null, ErrorCode.PARAMS_ERROR);
        String classname = classAddRequest.getClassName();
        String teacherId = classAddRequest.getTeacherId();
        ThrowUtils.throwIf(classname.isEmpty() || teacherId.isEmpty() , ErrorCode.PARAMS_ERROR);
        Class class1= new Class();
        BeanUtils.copyProperties(classAddRequest, class1);
        //默认状态未开课
        class1.setIsActive(0);
        boolean result = classService.save(class1);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(class1.getId());
    }

    }

