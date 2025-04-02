package com.zhibian.bianwanplatformbackend.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhibian.bianwanplatformbackend.model.dto.classhour.ClassHourAddRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentChangeClassRequest;
import com.zhibian.bianwanplatformbackend.model.dto.student.StudentQueryRequest;
import com.zhibian.bianwanplatformbackend.model.dto.user.UserQueryRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhibian.bianwanplatformbackend.model.entity.User;
import com.zhibian.bianwanplatformbackend.model.vo.StudentVO;
import com.zhibian.bianwanplatformbackend.model.vo.UserVO;

import java.util.List;

/**
* @author prw
* @description 针对表【student(学生)】的数据库操作Service
* @createDate 2025-04-01 19:59:10
*/
public interface StudentService extends IService<Student> {
    // 其他方法...

    /**
     * 更新学生的班级ID
     * @param studentChangeClassRequest 包含学生姓名和班级ID的请求对象
     * @return 是否更新成功
     */
    boolean updateClassId(StudentChangeClassRequest studentChangeClassRequest);

    /**
     * 统计班级中未请假的学生数
     * @param classHourAddRequest
     * @return 学生数量
     */
    int countStudentsNotLeave(ClassHourAddRequest classHourAddRequest);
    String getStudentIdsLeave(Long classId);

    QueryWrapper<Student> getQueryWrapper(StudentQueryRequest studentQueryRequest);
    StudentVO geStudentVO(Student student);
    List<StudentVO> getStudentVOList(List<Student> studentsList);


}
