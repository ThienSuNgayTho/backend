package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.Course;

public interface CourseService {
    
    void saveCourse(String courseName, String courseDescription, String courseImage, int payment, int levelId, int teacherId);

    Course findCourseById(int courseId);

    List<Course> findCourseByTeacherId(int teacherId);

    List<Course> findCourseByLevelId(int levelId);

    List<Course> findAllCourse();

    void updateCourse(Course course);

    void deleteCourse(int courseId);
}
