package com.englishweb.backend.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import com.englishweb.backend.repository.*;
import com.englishweb.backend.entity.*;

@Service
public class LessonServiceImpl implements LessonService{
    
    @Autowired
    LessonRepository lessonRepository;

    @Transactional
    @Override
    public void saveCourse(String lessonName, String content, int courseId, String pdfFile) {
        lessonRepository.saveLesson(lessonName, content, courseId, pdfFile);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> findAllByCourseId(int courseId) {
        return lessonRepository.findAllByCourseId(courseId);
    }

    @Override
    public void deleteLessonById(int lessonId) {
        lessonRepository.deleteById(lessonId);
    }
    
    @Override
    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public Lesson findLessonById(int lessonId){
        return lessonRepository.findById(lessonId).orElseThrow(() -> new IllegalArgumentException("Invalid lesson Id:" + lessonId));
    }

}
