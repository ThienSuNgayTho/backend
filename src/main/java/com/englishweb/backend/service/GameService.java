package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;

import java.util.List;

public interface GameService {
    List<FlashCard> findAll();
    List<FlashCard> findAllByLessonId(int lessonid);
}
