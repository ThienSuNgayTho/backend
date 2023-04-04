package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.*;
public interface LessonService {

    List<Lesson> findAll();

    List<Lesson> findAllByCourseId(int courseId);

    Lesson findLessonById(int lessonId);

    void deleteLessonById(int lessonId);

    void saveCourse(String lessonName, String content, int courseId, String pdfFile);

    void updateLesson(Lesson lesson);
}
