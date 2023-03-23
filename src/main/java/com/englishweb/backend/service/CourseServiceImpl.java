package com.englishweb.backend.service;

import org.springframework.stereotype.Service;

import com.englishweb.backend.entity.Course;
import com.englishweb.backend.repository.CourseRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    @Transactional
    @Override
    public void saveCourse(String courseName, String courseDescription, String courseImage, int payment, int levelId, int teacherId) {
        courseRepository.saveCourse(courseName, courseDescription, courseImage, payment, levelId, teacherId);
    }

    @Override
    public Course findCourseById(int courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + courseId));
    }

    @Override
    public List<Course> findCourseByTeacherId(int teacherId) {
        return courseRepository.findCourseByTeacherId(teacherId);
    }

    @Override
    public List<Course> findCourseByLevelId(int levelId) {
        return courseRepository.findCourseByLevelId(levelId);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }
}
