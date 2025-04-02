package com.zhibian.bianwanplatformbackend.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhibian.bianwanplatformbackend.annotation.AuthCheck;
import com.zhibian.bianwanplatformbackend.common.BaseResponse;
import com.zhibian.bianwanplatformbackend.common.ResultUtils;
import com.zhibian.bianwanplatformbackend.constant.UserConstant;
import com.zhibian.bianwanplatformbackend.exception.ErrorCode;
import com.zhibian.bianwanplatformbackend.exception.ThrowUtils;
import com.zhibian.bianwanplatformbackend.mapper.ClassHourMapper;
import com.zhibian.bianwanplatformbackend.model.dto.aclass.ClassAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.classhour.ClassHourAddRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Class;
import com.zhibian.bianwanplatformbackend.model.entity.ClassHour;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.zhibian.bianwanplatformbackend.service.ClassHourService;
import com.zhibian.bianwanplatformbackend.service.ClassService;
import com.zhibian.bianwanplatformbackend.service.StudentService;
import com.zhibian.bianwanplatformbackend.service.impl.ClassHourServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/class_hour")
public class ClassHourController {
    @Resource
    private ClassService classService;
    @Resource
    private StudentService studentService;
    @Resource
    private ClassHourService classHourService;

    /**
     * 创建用户
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> addClassHour(@RequestBody ClassHourAddRequest classHourAddRequest) {
        ThrowUtils.throwIf(classHourAddRequest == null, ErrorCode.PARAMS_ERROR);
        Long classId = classHourAddRequest.getClassId();
        Long teacherId = classHourAddRequest.getTeacherId();
        ThrowUtils.throwIf(classId == null || teacherId == null, ErrorCode.PARAMS_ERROR);
        int countStudentsNotLeave = studentService.countStudentsNotLeave(classHourAddRequest);
        String studentIdsLeave = studentService.getStudentIdsLeave(classId);

        // 创建 ClassHour 对象
        ClassHour classHour = new ClassHour();
        classHour.setClassId(classId);
        classHour.setTeacherId(teacherId);
        classHour.setCourseCount(countStudentsNotLeave);
        classHour.setLeave_list(studentIdsLeave);

        // 插入数据到数据库
        boolean result = classHourService.save(classHour);

        if (!result) {
            throw new RuntimeException("插入课时失败");
        }

        return ResultUtils.success(result);


    }

    }

