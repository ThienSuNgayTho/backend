package com.englishweb.backend.entity;

import java.util.Set;

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
    @JoinColumn(name = "levelId")
    private Level levelId;
    // getters and setters

    public WAQuestions() {
    }

    public WAQuestions(Long question_id, String questionText) {
        this.question_id = question_id;
        this.questionText = questionText;
    }

    // getters and setters

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

    public Level getLevelId() {
        return levelId;
    }

    public void setLevelId(Level levelId) {
        this.levelId = levelId;
    }

}
