package com.englishweb.backend.repository;

import com.englishweb.backend.entity.Lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{
    @Modifying
    @Query(value = "INSERT INTO lesson (lesson_name, content, pdf_file, course_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveLesson(String lessonName, String content, String pdfFile, int courseId);

    @Query(value = "SELECT * FROM lesson WHERE course_id = ?1", nativeQuery = true)
    List<Lesson> findAllByCourseId(int courseId);

    @Query(value = "SELECT * FROM lesson WHERE lessonid = ?1", nativeQuery = true)
    Lesson findLessonById(int lessonId);

    @Modifying
    @Query(value = "DELETE FROM lesson WHERE lessonid = ?1", nativeQuery = true)
    void deleteLessonById(int lessonId);

    @Modifying
    @Query(value = "UPDATE lesson SET lesson_name = ?1, content = ?2, pdf_file = ?3, course_id = ?4 WHERE lessonid = ?5", nativeQuery = true)
    void updateLessonById(String lessonName, String content, String pdfFile, int courseId, int lessonId);
}
