package com.englishweb.backend.service;

import java.util.List;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.repository.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    FlashCardRepository flashCardRepository;

    @Override
    public List<FlashCard> findAll() {
    return flashCardRepository.findAll();
    }

    @Override
    public List<FlashCard> findAllByLessonId(int lessonid){
        return flashCardRepository.findAllByLessonId(lessonid);
    }
}
