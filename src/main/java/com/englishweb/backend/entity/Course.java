package com.englishweb.backend.entity;
import jakarta.persistence.*;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "Descriptions")
    private String descriptions;

    @ManyToOne
    @JoinColumn(name = "LevelID")
    private Level level;

    @Column(name = "Images")
    private String images;

    @Column(name = "Payment")
    private Integer payment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "TeacherId", referencedColumnName = "UserID")
    private User teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Lesson> lessons;

    // Constructors, getters, and setters

    public Course() {
    }

    public Course(String courseName, String descriptions, Level level, String images, Integer payment, User teacher) {
        this.courseName = courseName;
        this.descriptions = descriptions;
        this.level = level;
        this.images = images;
        this.payment = payment;
        this.teacher = teacher;
    }

    // Getters and setters

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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

}

