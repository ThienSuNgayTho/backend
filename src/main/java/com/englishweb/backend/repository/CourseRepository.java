package com.englishweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.englishweb.backend.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT * FROM course WHERE teacher_id = ?1", nativeQuery = true)
    List<Course> findCourseByTeacherId(int teacherId);

    @Query(value = "SELECT * FROM course WHERE levelid = ?1", nativeQuery = true)
    List<Course> findCourseByLevelId(int levelId);

    @Modifying
    @Query(value = "DELETE FROM course WHERE courseid = ?1", nativeQuery = true)
    void deleteFullCourse(int courseId);

    @Query(value = "INSERT INTO course (course_name, descriptions, images, payment, levelid, public_id, teacher_id) VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void saveCourse(String courseName, String descriptions, String images, int payment,  int levelId, String pid, int teacherId);
}
