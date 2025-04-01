package com.zhibian.bianwanplatformbackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

/**
 * 学生
 * @TableName student
 */
@TableName(value ="student")
public class Student {
    /**
     * 学生ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像URL
     */
    private String avatar;

    /**
     * 所属班级ID
     */
    private Long classId;

    /**
     * 所属小学
     */
    private String elementarySchool;

    /**
     * 家长手机号
     */
    private String parentPhone;

    /**
     * 近期荣誉
     */
    private String recentHonors;

    /**
     * 剩余课时
     */
    private Integer remainingHours;

    /**
     * 当前积分（可抵扣学费，需应用层保证≥0）
     */
    private Integer currentPoints;

    /**
     * 是否请假
     */
    private Integer isLeave;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Integer isDelete;

    /**
     * 学生ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 学生ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 头像URL
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像URL
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 所属班级ID
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 所属班级ID
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 所属小学
     */
    public String getElementarySchool() {
        return elementarySchool;
    }

    /**
     * 所属小学
     */
    public void setElementarySchool(String elementarySchool) {
        this.elementarySchool = elementarySchool;
    }

    /**
     * 家长手机号
     */
    public String getParentPhone() {
        return parentPhone;
    }

    /**
     * 家长手机号
     */
    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    /**
     * 近期荣誉
     */
    public String getRecentHonors() {
        return recentHonors;
    }

    /**
     * 近期荣誉
     */
    public void setRecentHonors(String recentHonors) {
        this.recentHonors = recentHonors;
    }

    /**
     * 剩余课时
     */
    public Integer getRemainingHours() {
        return remainingHours;
    }

    /**
     * 剩余课时
     */
    public void setRemainingHours(Integer remainingHours) {
        this.remainingHours = remainingHours;
    }

    /**
     * 当前积分（可抵扣学费，需应用层保证≥0）
     */
    public Integer getCurrentPoints() {
        return currentPoints;
    }

    /**
     * 当前积分（可抵扣学费，需应用层保证≥0）
     */
    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }

    /**
     * 是否请假
     */
    public Integer getIsLeave() {
        return isLeave;
    }

    /**
     * 是否请假
     */
    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
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
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 逻辑删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getElementarySchool() == null ? other.getElementarySchool() == null : this.getElementarySchool().equals(other.getElementarySchool()))
            && (this.getParentPhone() == null ? other.getParentPhone() == null : this.getParentPhone().equals(other.getParentPhone()))
            && (this.getRecentHonors() == null ? other.getRecentHonors() == null : this.getRecentHonors().equals(other.getRecentHonors()))
            && (this.getRemainingHours() == null ? other.getRemainingHours() == null : this.getRemainingHours().equals(other.getRemainingHours()))
            && (this.getCurrentPoints() == null ? other.getCurrentPoints() == null : this.getCurrentPoints().equals(other.getCurrentPoints()))
            && (this.getIsLeave() == null ? other.getIsLeave() == null : this.getIsLeave().equals(other.getIsLeave()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getElementarySchool() == null) ? 0 : getElementarySchool().hashCode());
        result = prime * result + ((getParentPhone() == null) ? 0 : getParentPhone().hashCode());
        result = prime * result + ((getRecentHonors() == null) ? 0 : getRecentHonors().hashCode());
        result = prime * result + ((getRemainingHours() == null) ? 0 : getRemainingHours().hashCode());
        result = prime * result + ((getCurrentPoints() == null) ? 0 : getCurrentPoints().hashCode());
        result = prime * result + ((getIsLeave() == null) ? 0 : getIsLeave().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", avatar=").append(avatar);
        sb.append(", classId=").append(classId);
        sb.append(", elementarySchool=").append(elementarySchool);
        sb.append(", parentPhone=").append(parentPhone);
        sb.append(", recentHonors=").append(recentHonors);
        sb.append(", remainingHours=").append(remainingHours);
        sb.append(", currentPoints=").append(currentPoints);
        sb.append(", isLeave=").append(isLeave);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}