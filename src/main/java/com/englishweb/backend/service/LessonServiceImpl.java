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
    public void saveCourse(String lessonName, String content, String pdfFile, int courseId) {
        lessonRepository.saveLesson(lessonName, content, pdfFile, courseId);
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

    @Transactional
    @Override
    public void updateLessonById(LessonDTO lessonDTO) {
        lessonRepository.updateLessonById(lessonDTO.getLessonName(), lessonDTO.getContent(), lessonDTO.getPdfFile(), lessonDTO.getCourseId(), lessonDTO.getLessonId());
    }

}
