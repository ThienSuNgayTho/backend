package com.englishweb.backend.entity;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LessonID")
    private int lessonId;

    @Column(name = "LessonName")
    private String lessonName;

    @Column(name = "Content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CourseId")
    private Course course;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<FlashCard> flashCard;
    // constructors, getters, and setters

    public Lesson() {}

    public Lesson(String lessonName, String content, Course course) {
        this.lessonName = lessonName;
        this.content = content;
        this.course = course;
    }

    // getters and setters

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
