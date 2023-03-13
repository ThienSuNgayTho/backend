package com.englishweb.backend.repository;

import com.englishweb.backend.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<FlashCard, Long > {
    @Query(value = "SELECT * FROM flash_card WHERE lessonid = ?1", nativeQuery = true)
    List<FlashCard> findAllByLessonId(int lessonid);
}
