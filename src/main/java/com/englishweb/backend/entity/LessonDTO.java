package com.englishweb.backend.entity;

public class LessonDTO {
    private int lessonId;
    private String lessonName;
    private String content;
    private int courseId;
    private String pdfFile;

    public LessonDTO(int lessonId, String lessonName, String content, int courseId, String pdfFile) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.content = content;
        this.courseId = courseId;
        this.pdfFile = pdfFile;
    }

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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }
}
