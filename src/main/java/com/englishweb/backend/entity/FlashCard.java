package com.englishweb.backend.entity;

import jakarta.persistence.*;

@Entity
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flashCardId;

    private String frontHTML;

    private String backHTML;

    @ManyToOne(fetch = FetchType.EAGER)
    public Long getFlashCardId() {
        return flashCardId;
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LessonID")
    private Lesson lesson;

    public void setFlashCardId(Long flashCardId) {
        this.flashCardId = flashCardId;
    }


    public String getFrontHTML() {
        return frontHTML;
    }

    public void setFrontHTML(String frontHTML) {
        this.frontHTML = frontHTML;
    }

    public String getBackHTML() {
        return backHTML;
    }

    public void setBackHTML(String backHTML) {
        this.backHTML = backHTML;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
