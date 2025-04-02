package com.zhibian.bianwanplatformbackend.service;

import com.zhibian.bianwanplatformbackend.model.dto.student.StudentChangeClassRequest;
import com.zhibian.bianwanplatformbackend.model.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
