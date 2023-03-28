package com.englishweb.backend.entity;

public class FlashCardDTO {
    private Long id;
    private String frontHTML;
    private String backHTML;
    private int lessonId;

    public FlashCardDTO(Long id, String frontHTML, String backHTML, int lessonId) {
        this.id = id;
        this.frontHTML = frontHTML;
        this.backHTML = backHTML;
        this.lessonId = lessonId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}
