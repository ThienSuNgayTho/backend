package com.englishweb.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private int courseID;

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
    private int payment;

    @Column(name = "PublicId")
    private String pid;

    @ManyToOne
    @JoinColumn(name = "TeacherId")
    private User teacher;

    // Constructors, getters, and setters

    public Course() {
    }

    public Course(String courseName, String descriptions, Level level, String images, int payment, String pid,
            User teacher) {
        this.courseName = courseName;
        this.descriptions = descriptions;
        this.level = level;
        this.images = images;
        this.payment = payment;
        this.pid = pid;
        this.teacher = teacher;
    }

}
