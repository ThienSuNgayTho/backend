package com.englishweb.backend.repository;

import com.englishweb.backend.entity.Lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{
    @Modifying
    @Query(value = "INSERT INTO lesson (lesson_name, content, course_id, pdf_file) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveLesson(String lessonName, String content, int courseId, String pdfFile);

    @Query(value = "SELECT * FROM lesson WHERE course_id = ?1", nativeQuery = true)
    List<Lesson> findAllByCourseId(int courseId);

    @Query(value = "SELECT * FROM lesson WHERE lessonid = ?1", nativeQuery = true)
    Lesson findLessonById(int lessonId);

    @Modifying
    @Query(value = "DELETE FROM lesson WHERE lessonid = ?1", nativeQuery = true)
    void deleteLessonById(int lessonId);
}
