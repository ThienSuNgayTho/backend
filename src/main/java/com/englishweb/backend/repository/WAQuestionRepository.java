package com.englishweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.WAQuestions;

public interface WAQuestionRepository extends JpaRepository<WAQuestions, Long> {

    @Query(value = "SELECT * FROM questions WHERE lessonid = ?1", nativeQuery = true)
    List<WAQuestions> findAllByLessonId2(int lessonid);

    List<WAQuestions> findAll();

    @Modifying
    @Query(value = "INSERT INTO questions ( question_text, lessonid) VALUES (?1, ?2)", nativeQuery = true)
    void saveQuestions(String questionText, int lessonid);

    @Query(value = "SELECT * FROM questions WHERE question_id = ?1", nativeQuery = true)
    WAQuestions findQuestionsById(Long questionId);

    @Query(value = "DELETE FROM questions WHERE question_id = ?1", nativeQuery = true)
    void deleteQuestionsById(Long questionId);
}