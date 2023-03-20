package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<FlashCard> findAll();

    List<FlashCard> findAllByLessonId(int lessonid);

    void saveFlashCard(FlashCard flashCard);

    void deleteFlashCardById(Long flashCardId);

    FlashCard findFlashCardById(Long flashCardId);

}
