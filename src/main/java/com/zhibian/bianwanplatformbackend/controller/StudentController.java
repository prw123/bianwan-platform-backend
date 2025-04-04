package com.zhibian.bianwanplatformbackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhibian.bianwanplatformbackend.annotation.AuthCheck;
import com.zhibian.bianwanplatformbackend.common.BaseResponse;
import com.zhibian.bianwanplatformbackend.common.ResultUtils;
import com.zhibian.bianwanplatformbackend.constant.UserConstant;
import com.zhibian.bianwanplatformbackend.exception.ErrorCode;
import com.zhibian.bianwanplatformbackend.exception.ThrowUtils;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentChangeClassRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentQueryRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentUpdateRequest;
import com.zhibian.bianwanplatformbackend.model.dto.user.UserAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.user.UserQueryRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.zhibian.bianwanplatformbackend.model.entity.User;
import com.zhibian.bianwanplatformbackend.model.enums.StudentStatusEnum;
import com.zhibian.bianwanplatformbackend.model.vo.StudentVO;
import com.zhibian.bianwanplatformbackend.model.vo.UserVO;
import com.zhibian.bianwanplatformbackend.service.StudentService;
import com.zhibian.bianwanplatformbackend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
        student.setIsLeave(StudentStatusEnum.READING.getCode());
        boolean result = studentService.save(student);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(student.getId());
    }

    @PostMapping("/add/class")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> addStudentClass(@RequestBody StudentChangeClassRequest studentChangeClassRequest) {
        ThrowUtils.throwIf(studentChangeClassRequest == null, ErrorCode.PARAMS_ERROR);
        boolean result = studentService.updateClassId(studentChangeClassRequest);
        return ResultUtils.success(result);
    }

    @PostMapping("/list/page/vo")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<StudentVO>> listStudentVOByPage(@RequestBody StudentQueryRequest studentQueryRequest) {
        ThrowUtils.throwIf(studentQueryRequest == null, ErrorCode.PARAMS_ERROR);
        long current = studentQueryRequest.getCurrent();
        long pageSize = studentQueryRequest.getPageSize();
        Page<Student>  studentPage= studentService.page(new Page<>(current, pageSize),
                studentService.getQueryWrapper(studentQueryRequest));
        Page<StudentVO> studentVOPage = new Page<>(current, pageSize, studentPage.getTotal());
        List<StudentVO> studentVOList = studentService.getStudentVOList(studentPage.getRecords());
        studentVOPage.setRecords(studentVOList);
        return ResultUtils.success(studentVOPage);
    }

}
