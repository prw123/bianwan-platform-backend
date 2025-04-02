package com.zhibian.bianwanplatformbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhibian.bianwanplatformbackend.exception.ErrorCode;
import com.zhibian.bianwanplatformbackend.exception.ThrowUtils;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentChangeClassRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.zhibian.bianwanplatformbackend.service.StudentService;
import com.zhibian.bianwanplatformbackend.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author prw
* @description 针对表【student(学生)】的数据库操作Service实现
* @createDate 2025-04-01 19:59:10
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Override
    public boolean updateClassId(StudentChangeClassRequest studentChangeClassRequest) {
        String name = studentChangeClassRequest.getName();
        Long classId = studentChangeClassRequest.getClassId();
        ThrowUtils.throwIf(name.isEmpty() || classId==null, ErrorCode.PARAMS_ERROR);
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", name).set("classId", classId);
        return this.baseMapper.update(null, updateWrapper) > 0;

    }
}




