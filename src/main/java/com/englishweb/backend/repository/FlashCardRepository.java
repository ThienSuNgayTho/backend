package com.englishweb.backend.repository;

import com.englishweb.backend.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long > {
    @Query(value = "SELECT * FROM flash_card WHERE lessonid = ?1", nativeQuery = true)
    List<FlashCard> findAllByLessonId(int lessonid);

    @Modifying
    @Query(value = "INSERT INTO flash_card (fronthtml, backhtml, lessonid) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void saveFlashCard(String frontHTML, String backHTML, int lessonId);

    @Modifying
    @Query(value = "UPDATE flash_card SET fronthtml = ?1, backhtml = ?2, lessonid = ?3 WHERE flash_card_id = ?4 ", nativeQuery = true)
    void updateFlashCard(String frontHTML, String backHTML, int lessonId, Long flashCardId);
}
