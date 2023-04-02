package com.englishweb.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "LevelID")
    private Level level;

    @Column(name = "Images")
    private String images;

    @Column(name = "Payment")
    private int payment;

    @Column(name = "PublicId")
    private String pid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TeacherId", referencedColumnName = "UserID", nullable = false)
    private User teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Lesson> lessons;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "TopicID", nullable = false)
    private Topic topic;    

    // Constructors, getters, and setters

    public Course() {
    }

    public Course(String courseName, String descriptions, Level level, String images, int payment, String pid,
            User teacher, Topic topic) {
        this.courseName = courseName;
        this.descriptions = descriptions;
        this.level = level;
        this.images = images;
        this.payment = payment;
        this.pid = pid;
        this.teacher = teacher;
        this.topic = topic;
    }

}
