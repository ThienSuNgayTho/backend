package com.englishweb.backend.entity;

public class LessonDTO {
    private int lessonId;

    private String lessonName;

    private String content;

    private String pdfFile;

    private int courseId;



    public LessonDTO(String lessonName, String content, String pdfFile, int courseId,int lessonId ) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.content = content;
        this.pdfFile = pdfFile;
        this.courseId = courseId;
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

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
