package com.zhibian.bianwanplatformbackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 课时
 * @TableName class_hour
 */
@TableName(value ="class_hour")
public class ClassHour {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 教师ID
     */
    private Long teacherId;

    /**
     * 课时数
     */
    private Integer courseCount;

    /**
     * 应到人数
     */
    private Integer expected_attendance;

    /**
     * 实到人数
     */
    private Integer actual_attendance;

    /**
     * 请假学生ID列表
     */
    private String leave_list;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 审核状态：0-待审核;1-通过;2-拒绝
     */
    private Integer reviewStatus;

    /**
     * 审核信息
     */
    private String reviewMessage;

    /**
     * 审核人ID
     */
    private Long reviewerId;

    /**
     * 审核时间
     */
    private Date reviewTime;

    /**
     * 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 班级ID
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 班级ID
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 教师ID
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 教师ID
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 课时数
     */
    public Integer getCourseCount() {
        return courseCount;
    }

    /**
     * 课时数
     */
    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    /**
     * 应到人数
     */
    public Integer getExpected_attendance() {
        return expected_attendance;
    }

    /**
     * 应到人数
     */
    public void setExpected_attendance(Integer expected_attendance) {
        this.expected_attendance = expected_attendance;
    }

    /**
     * 实到人数
     */
    public Integer getActual_attendance() {
        return actual_attendance;
    }

    /**
     * 实到人数
     */
    public void setActual_attendance(Integer actual_attendance) {
        this.actual_attendance = actual_attendance;
    }

    /**
     * 请假学生ID列表
     */
    public String getLeave_list() {
        return leave_list;
    }

    /**
     * 请假学生ID列表
     */
    public void setLeave_list(String leave_list) {
        this.leave_list = leave_list;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 审核状态：0-待审核;1-通过;2-拒绝
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 审核状态：0-待审核;1-通过;2-拒绝
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    /**
     * 审核信息
     */
    public String getReviewMessage() {
        return reviewMessage;
    }

    /**
     * 审核信息
     */
    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    /**
     * 审核人ID
     */
    public Long getReviewerId() {
        return reviewerId;
    }

    /**
     * 审核人ID
     */
    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 审核时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 审核时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ClassHour other = (ClassHour) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getCourseCount() == null ? other.getCourseCount() == null : this.getCourseCount().equals(other.getCourseCount()))
            && (this.getExpected_attendance() == null ? other.getExpected_attendance() == null : this.getExpected_attendance().equals(other.getExpected_attendance()))
            && (this.getActual_attendance() == null ? other.getActual_attendance() == null : this.getActual_attendance().equals(other.getActual_attendance()))
            && (this.getLeave_list() == null ? other.getLeave_list() == null : this.getLeave_list().equals(other.getLeave_list()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getReviewStatus() == null ? other.getReviewStatus() == null : this.getReviewStatus().equals(other.getReviewStatus()))
            && (this.getReviewMessage() == null ? other.getReviewMessage() == null : this.getReviewMessage().equals(other.getReviewMessage()))
            && (this.getReviewerId() == null ? other.getReviewerId() == null : this.getReviewerId().equals(other.getReviewerId()))
            && (this.getReviewTime() == null ? other.getReviewTime() == null : this.getReviewTime().equals(other.getReviewTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getCourseCount() == null) ? 0 : getCourseCount().hashCode());
        result = prime * result + ((getExpected_attendance() == null) ? 0 : getExpected_attendance().hashCode());
        result = prime * result + ((getActual_attendance() == null) ? 0 : getActual_attendance().hashCode());
        result = prime * result + ((getLeave_list() == null) ? 0 : getLeave_list().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getReviewStatus() == null) ? 0 : getReviewStatus().hashCode());
        result = prime * result + ((getReviewMessage() == null) ? 0 : getReviewMessage().hashCode());
        result = prime * result + ((getReviewerId() == null) ? 0 : getReviewerId().hashCode());
        result = prime * result + ((getReviewTime() == null) ? 0 : getReviewTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classId=").append(classId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", courseCount=").append(courseCount);
        sb.append(", expected_attendance=").append(expected_attendance);
        sb.append(", actual_attendance=").append(actual_attendance);
        sb.append(", leave_list=").append(leave_list);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", reviewStatus=").append(reviewStatus);
        sb.append(", reviewMessage=").append(reviewMessage);
        sb.append(", reviewerId=").append(reviewerId);
        sb.append(", reviewTime=").append(reviewTime);
        sb.append("]");
        return sb.toString();
    }
}