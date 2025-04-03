package com.zhibian.bianwanplatformbackend.service;

import com.zhibian.bianwanplatformbackend.model.entity.Class;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhibian.bianwanplatformbackend.model.vo.ClassVO;

import java.util.List;

/**
* @author prw
* @description 针对表【class(班级)】的数据库操作Service
* @createDate 2025-04-02 13:53:42
*/
public interface ClassService extends IService<Class> {
    /**
     * 根据班级id获取班级名称
     * @param classId
     * @return
     */
    String getClassNameById(Long classId);
}
