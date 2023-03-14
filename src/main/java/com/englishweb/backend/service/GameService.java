package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;

import java.util.List;

public interface GameService {
    List<FlashCard> findAll();
    List<FlashCard> findAllByLessonId(int lessonid);
}
