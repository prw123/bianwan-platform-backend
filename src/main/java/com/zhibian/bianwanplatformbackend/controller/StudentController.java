package com.zhibian.bianwanplatformbackend.controller;

import com.zhibian.bianwanplatformbackend.annotation.AuthCheck;
import com.zhibian.bianwanplatformbackend.common.BaseResponse;
import com.zhibian.bianwanplatformbackend.common.ResultUtils;
import com.zhibian.bianwanplatformbackend.constant.UserConstant;
import com.zhibian.bianwanplatformbackend.exception.ErrorCode;
import com.zhibian.bianwanplatformbackend.exception.ThrowUtils;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.user.UserAddRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.zhibian.bianwanplatformbackend.model.entity.User;
import com.zhibian.bianwanplatformbackend.service.StudentService;
import com.zhibian.bianwanplatformbackend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    /**
     * 创建用户
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Long> addStudent(@RequestBody StudentAddRequest studentAddRequest) {
        ThrowUtils.throwIf(studentAddRequest == null, ErrorCode.PARAMS_ERROR);
        String name = studentAddRequest.getName();
        String parentPhone = studentAddRequest.getParentPhone();
        String elementarySchool = studentAddRequest.getElementarySchool();
        ThrowUtils.throwIf(name.isEmpty() , ErrorCode.PARAMS_ERROR);
        Student student = new Student();
        BeanUtils.copyProperties(studentAddRequest, student);
        //默认状态为未请假
        student.setIsLeave(0);
        boolean result = studentService.save(student);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(student.getId());
    }
}
