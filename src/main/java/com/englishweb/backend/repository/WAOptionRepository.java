package com.englishweb.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;

@Repository
public interface WAOptionRepository extends JpaRepository<WAOptions, Long> {
    @Query(value = "SELECT * FROM options WHERE question_id = ?1", nativeQuery = true)
    List<WAOptions> findByQuestion(Long questionid);

    @Modifying
    @Query(value = "INSERT INTO options (option_id, is_correct,option_text, question_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveOptions(Long optionId, boolean isCorrect, String optionText, Long questionId);
}
