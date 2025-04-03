package com.zhibian.bianwanplatformbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhibian.bianwanplatformbackend.model.entity.Class;
import com.zhibian.bianwanplatformbackend.service.ClassService;
import com.zhibian.bianwanplatformbackend.mapper.ClassMapper;
import org.springframework.stereotype.Service;

/**
* @author prw
* @description 针对表【class(班级)】的数据库操作Service实现
* @createDate 2025-04-02 13:53:42
*/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class>
    implements ClassService{

    @Override
    public String getClassNameById(Long classId) {
        if (classId == null) {
            return null;
        }
        // 根据 classId 查询班级实体
        Class classEntity = this.getById(classId);
        return classEntity != null ? classEntity.getClassName() : null;
    }
}




