-- 创建库
create database if not exists bianwan_platform;
-- 切换库
use bianwan_platform;
-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin',
    editTime     datetime     default CURRENT_TIMESTAMP not null comment '编辑时间',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    UNIQUE KEY uk_userAccount (userAccount),
    INDEX idx_userName (userName)
    ) comment '用户' collate = utf8mb4_unicode_ci;
CREATE TABLE IF NOT EXISTS class_hour (
                                          id           BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
                                          classId      BIGINT   NOT NULL COMMENT '班级ID',
                                          teacherId    BIGINT   NOT NULL COMMENT '教师ID',
                                          courseCount  INT      NOT NULL DEFAULT 0 COMMENT '课时数',
                                          expected_attendance INT NOT NULL DEFAULT 0 COMMENT '应到人数',
                                          actual_attendance INT NOT NULL DEFAULT 0 COMMENT '实到人数',
                                          leave_list VARCHAR(1024) NOT NULL DEFAULT '' COMMENT '请假学生ID列表',
                                          createTime   DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                                          updateTime   DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                          isDelete     TINYINT  DEFAULT 0 NOT NULL COMMENT '是否删除',
                                          reviewStatus INT DEFAULT 0 NOT NULL COMMENT '审核状态：0-待审核;1-通过;2-拒绝',
                                          reviewMessage VARCHAR(512) NULL COMMENT '审核信息',
                                          reviewerId BIGINT NULL COMMENT '审核人ID',
                                          reviewTime DATETIME NULL COMMENT '审核时间',
                                          INDEX idx_class_teacher (classId, teacherId),
                                          INDEX idx_reviewStatus (reviewStatus)
) comment '课时' collate = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `class` (
                                       id          BIGINT AUTO_INCREMENT COMMENT '班级ID' PRIMARY KEY,
                                       className   VARCHAR(256) NOT NULL COMMENT '班级名称',
    -- 新增是否开班字段（默认否）
                                       isActive    TINYINT(1)   DEFAULT 0 NOT NULL COMMENT '是否开班（0-未开班，1-已开班）',
                                       createTime  DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                                       updateTime  DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                       isDelete    TINYINT      DEFAULT 0 NOT NULL COMMENT '逻辑删除（0-未删除，1-已删除）',

    -- 唯一索引防止班级名重复
                                       UNIQUE INDEX uk_className (className),
    -- 按开班状态查询优化
                                       INDEX idx_isActive (isActive)
) comment '班级' COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `student` (
                                         id              BIGINT AUTO_INCREMENT COMMENT '学生ID' PRIMARY KEY,
                                         name            VARCHAR(256) NOT NULL COMMENT '姓名',
                                         avatar          VARCHAR(512) NULL COMMENT '头像URL',
                                         classId         BIGINT       NOT NULL COMMENT '所属班级ID',
                                         elementarySchool VARCHAR(100) NULL COMMENT '所属小学',
                                         parentPhone     VARCHAR(20)  NULL COMMENT '家长手机号',
                                         recentHonors    TEXT         NULL COMMENT '近期荣誉',
                                         remainingHours  INT          DEFAULT 0 NOT NULL COMMENT '剩余课时',
                                         currentPoints   INT          DEFAULT 0 NOT NULL COMMENT '当前积分（可抵扣学费，需应用层保证≥0）',
                                         isLeave         TINYINT      DEFAULT 0 NOT NULL COMMENT '是否请假',
                                         createTime      DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                                         updateTime      DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                         isDelete        TINYINT      DEFAULT 0 NOT NULL COMMENT '逻辑删除',

    -- 外键约束
                                         FOREIGN KEY (classId) REFERENCES `class`(id),

    -- 索引与校验
                                         INDEX idx_classId (classId),
                                         INDEX idx_points (currentPoints),  -- 积分排行榜查询优化
                                         CHECK (remainingHours >= 0 AND currentPoints >= 0)  -- 逻辑校验（MySQL 8.0+生效）
) comment '学生' COLLATE=utf8mb4_unicode_ci;