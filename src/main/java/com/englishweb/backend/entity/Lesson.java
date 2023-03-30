package com.englishweb.backend.entity;
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

    // constructors, getters, and setters

    public Lesson() {}

    public Lesson(String lessonName, String content, Course course) {
        this.lessonName = lessonName;
        this.content = content;
        this.course = course;
    }

    // getters and setters

    public int getLessonId() {
        return this.lessonId;
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
