package com.englishweb.backend.entity;

public class FillInBlankDTO {
    private long id;

    private String question;

    private String answer;

    private Long level;

    public FillInBlankDTO(long id, String question, String answer, Long level) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getLevel() {
        return level;
    }
    
    public void setLevel(Long level) {
        this.level = level;
    }
}
