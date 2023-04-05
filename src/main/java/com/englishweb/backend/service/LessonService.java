package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.*;
public interface LessonService {

    List<Lesson> findAll();

    List<Lesson> findAllByCourseId(int courseId);

    Lesson findLessonById(int lessonId);

    void deleteLessonById(int lessonId);

    void saveCourse(String lessonName, String content, String pdfFile, int courseId);

    void updateLesson(Lesson lesson);

    void updateLessonById(LessonDTO lessonDTO);
}
