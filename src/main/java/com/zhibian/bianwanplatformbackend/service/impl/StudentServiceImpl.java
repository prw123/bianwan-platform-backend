package com.zhibian.bianwanplatformbackend.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhibian.bianwanplatformbackend.exception.BusinessException;
import com.zhibian.bianwanplatformbackend.exception.ErrorCode;
import com.zhibian.bianwanplatformbackend.exception.ThrowUtils;
import com.zhibian.bianwanplatformbackend.model.dto.classhour.ClassHourAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentChangeClassRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentQueryRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.zhibian.bianwanplatformbackend.model.entity.User;
import com.zhibian.bianwanplatformbackend.model.vo.StudentVO;
import com.zhibian.bianwanplatformbackend.model.vo.UserVO;
import com.zhibian.bianwanplatformbackend.service.ClassService;
import com.zhibian.bianwanplatformbackend.service.StudentService;
import com.zhibian.bianwanplatformbackend.mapper.StudentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public int countStudentsNotLeave(ClassHourAddRequest classHourAddRequest){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        Long classId = classHourAddRequest.getClassId();
        queryWrapper.eq("classId", classId).eq("isLeave", 0);
        return Math.toIntExact(this.baseMapper.selectCount(queryWrapper));
    }
    @Override
    public String getStudentIdsLeave(Long classId) {
        // 获取 isLeave 为 1 的学生 ID 列表
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("classId", classId).eq("isLeave", 1);
        List<Student> students = this.baseMapper.selectList(queryWrapper);

        // 将学生 ID 列表转换为逗号分隔的字符串
        return students.stream()
                .map(Student::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public QueryWrapper<Student> getQueryWrapper(StudentQueryRequest studentQueryRequest) {
        if (studentQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        String elementarySchool = studentQueryRequest.getElementarySchool();
        String parentPhone = studentQueryRequest.getParentPhone();
        String name = studentQueryRequest.getName();
        String recentHonors = studentQueryRequest.getRecentHonors();
        Integer remainingHours = studentQueryRequest.getRemainingHours();
        Integer currentPoints = studentQueryRequest.getCurrentPoints();
        Integer isLeave = studentQueryRequest.getIsLeave();
        String sortField = studentQueryRequest.getSortField();
        String sortOrder = studentQueryRequest.getSortOrder();
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ObjUtil.isNotNull(name), "name", name);
        queryWrapper.eq(StrUtil.isNotBlank(elementarySchool), "elementarySchool", elementarySchool);
        queryWrapper.like(StrUtil.isNotBlank(parentPhone), "parentPhone", parentPhone);
        queryWrapper.like(StrUtil.isNotBlank(recentHonors), "recentHonors", recentHonors);
        queryWrapper.eq(ObjUtil.isNotNull(remainingHours), "remainingHours", remainingHours);
        queryWrapper.eq(ObjUtil.isNotNull(currentPoints), "currentPoints", currentPoints);
        queryWrapper.eq(ObjUtil.isNotNull(isLeave), "isLeave", isLeave);
        queryWrapper.orderBy(StrUtil.isNotEmpty(sortField), sortOrder.equals("ascend"), sortField);
        return queryWrapper;
    }

    @Autowired
    ClassService classService;

    @Override
    public StudentVO geStudentVO(Student student) {
        if (student == null) {
            return null;
        }
        StudentVO studentVO = new StudentVO();
        BeanUtils.copyProperties(student, studentVO);
        /**
         * 在返回包里加上班级的名称，通过班级id获取
         */
        Long classId = student.getClassId();
        String className = classService.getClassNameById(classId);
        studentVO.setClassName(className);
        return studentVO;
    }

    @Override
    public List<StudentVO> getStudentVOList(List<Student> studentsList) {
        if (CollUtil.isEmpty(studentsList)) {
            return new ArrayList<>();
        }
        return studentsList.stream().map(this::geStudentVO).collect(Collectors.toList());

    }
}




