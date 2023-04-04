package com.englishweb.backend.entity;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class WAQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;

    @Column(name = "question_text")
    private String questionText;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LessonID")
    private Lesson lesson;
    // @JoinColumn(name ="LessonName")
    // private Lesson lessonName;

    @OneToMany(mappedBy = "question", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<WAOptions> option;
    // getters and setters
    // getters and setters

    public WAQuestions() {
    }

    public WAQuestions(Long question_id, String questionText) {
        this.question_id = question_id;
        this.questionText = questionText;
    }

    public long getId() {
        return question_id;
    }

    public void setId(long question_id) {
        this.question_id = question_id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    // public Lesson getLessonName() {
    // return lessonName;
    // }

    // public void setLessonName(Lesson lessonName) {
    // this.lessonName = lessonName;
    // }

}
