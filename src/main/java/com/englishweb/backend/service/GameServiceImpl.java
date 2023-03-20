package com.englishweb.backend.service;


import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.repository.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void saveFlashCard (FlashCard flashCard){
        flashCardRepository.save(flashCard);
    }

    @Override
    public void deleteFlashCardById(Long flashCardId){
        flashCardRepository.deleteById(flashCardId);
    }

    @Override
    public FlashCard findFlashCardById(Long flashCardId){
       return flashCardRepository.findById(flashCardId).orElseThrow(() -> new IllegalArgumentException("Invalid flashcard Id:" + flashCardId));
    }
}
