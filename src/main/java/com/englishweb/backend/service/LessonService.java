package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.*;
public interface LessonService {

    List<Lesson> findAll();

    List<Lesson> findAllByCourseId(int courseId);

    void saveLesson(String lessonName, String content, int courseId);

    void deleteLessonById(int lessonId);

    
}
