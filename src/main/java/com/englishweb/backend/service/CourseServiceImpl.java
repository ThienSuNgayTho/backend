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
    public void saveCourse(String courseName, String courseDescription, String courseImage, int payment,
            int levelId, String pid, int teacherId, int topicId) {
        courseRepository.saveCourse(courseName, courseDescription, courseImage, payment, levelId, pid, teacherId, topicId);
        // courseRepository.saveAndFlush(course);
    }

    @Override
    public Course findCourseById(int courseId) {
        return courseRepository.findCourseById(courseId);
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

    @Transactional
    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteFullCourse(courseId);       
    }

    // @Override
    // public void saveCourse(String courseName, String courseDescription, String
    // courseImage, int payment, int levelId,
    // int teacherId) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'saveCourse'");
    // }
}
