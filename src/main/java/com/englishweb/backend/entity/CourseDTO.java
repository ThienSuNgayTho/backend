package com.englishweb.backend.entity;

public class CourseDTO {
    private Integer courseID;
    private String courseName;
    private String descriptions;
    private String images;
    private Integer payment;
    private Integer levelId;
    private Integer teacherId;
    private Integer topicId;

    public CourseDTO() {
    }

    public CourseDTO(Integer courseID, String courseName, String descriptions, String images, Integer payment,
            Integer levelId, Integer teacherId, Integer topicId) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.descriptions = descriptions;
        this.images = images;
        this.payment = payment;
        this.levelId = levelId;
        this.teacherId = teacherId;
        this.topicId = topicId;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}
