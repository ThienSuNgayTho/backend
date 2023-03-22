package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<FlashCard> findAll();

    List<FlashCard> findAllByLessonId(int lessonid);

    void saveFlashCard(String frontHTML, String backHTML, int lessonId);

    void deleteFlashCardById(Long flashCardId);

    FlashCard findFlashCardById(Long flashCardId);

    void updateFlashCard(FlashCard flashCard);

}
