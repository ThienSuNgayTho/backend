package com.englishweb.backend.service;


import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.FlashCardDTO;
import com.englishweb.backend.repository.FlashCardRepository;

import jakarta.transaction.Transactional;

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

    @Transactional
    @Override
    public void saveFlashCard (String frontHTML, String backHTML, int lessonId){
        flashCardRepository.saveFlashCard(frontHTML, backHTML, lessonId);;
    }

    @Override
    public void deleteFlashCardById(Long flashCardId){
        flashCardRepository.deleteById(flashCardId);
    }

    @Override
    public FlashCard findFlashCardById(Long flashCardId){
       return flashCardRepository.findById(flashCardId).orElseThrow(() -> new IllegalArgumentException("Invalid flashcard Id:" + flashCardId));
    }

    @Transactional
    @Override
    public void updateFlashCard(FlashCardDTO flashCard){
        System.out.println(flashCard.getId());
        flashCardRepository.updateFlashCard(flashCard.getFrontHTML(), flashCard.getBackHTML(), flashCard.getLessonId(), flashCard.getId());
    }
}
