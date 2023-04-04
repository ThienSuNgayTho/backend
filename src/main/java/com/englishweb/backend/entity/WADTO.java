package com.englishweb.backend.entity;

import java.util.List;

public class WADTO {

    private Long question_id;
    private String questionText;
    private List<WAOptions> option;
    private int lessonid;

    public WADTO() {
    }

    public WADTO(Long question_id, String questionText, List<WAOptions> option, int lessonid) {
        this.question_id = question_id;
        this.questionText = questionText;
        this.option = option;
        this.lessonid = lessonid;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<WAOptions> getOption() {
        return option;
    }

    public void setOption(List<WAOptions> option) {
        this.option = option;
    }

    public int getLessonid() {
        return lessonid;
    }

    public void setLessonid(int lessonid) {
        this.lessonid = lessonid;
    }
}
