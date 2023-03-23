package com.englishweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.WAQuestions;

public interface WAQuestionRepository extends JpaRepository<WAQuestions, Long> {

    @Query(value = "SELECT * FROM questions WHERE level_id = ?1", nativeQuery = true)
    List<WAQuestions> findAllByLevelId(Long levelid);

    List<WAQuestions> findAll();
}