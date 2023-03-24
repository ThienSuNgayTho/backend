package com.englishweb.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import com.englishweb.backend.repository.*;
import com.englishweb.backend.entity.*;

@Service
public class LessonServiceImpl implements LessonService{
    
    @Autowired
    LessonRepository lessonRepository;

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
    public void saveLessonByCourse(String lessonName, String content, int courseId) {
        lessonRepository.saveLesson(lessonName, content, courseId);
    }
}
