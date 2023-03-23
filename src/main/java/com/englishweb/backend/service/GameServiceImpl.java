package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.repository.FillInBlankRepository;
import com.englishweb.backend.repository.FlashCardRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    FlashCardRepository flashCardRepository;

    @Autowired
    FillInBlankRepository fillInBlankRepository;

    @Override
    public List<FlashCard> findAll() {
    return flashCardRepository.findAll();
    }

    @Override
    public List<FlashCard> findAllByLessonId(int lessonid){
        return flashCardRepository.findAllByLessonId(lessonid);
    }

    @Override
    public List<FillInBlank> findAllByLevelId(Long levelid){
        return fillInBlankRepository.findAllByLevelId(levelid);
    }

    @Override
    public List<FillInBlank> findAllFillInBlank(){
        return fillInBlankRepository.findAll();
    }

    @Override
    public void saveFillInBlank(FillInBlank fillInBlank){
        fillInBlankRepository.save(fillInBlank);
    }

    @Override
    public void deleteFillInBlank(Long id){
        fillInBlankRepository.deleteById(id);
    }

    @Override
    public FillInBlank findFillInBlanksById(Long id){
        return fillInBlankRepository.findById(id).orElseThrow(() -> new RuntimeException("FillInBlank not found"));
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

    @Override
    public void updateFlashCard(FlashCard flashCard){
        flashCardRepository.save(flashCard);
    }
    
    @Transactional
    @Override
    public void saveFillInBlankByLevel(String question, String answer, Long levelId){
        fillInBlankRepository.saveFillInBlankByLevel(question, answer, levelId);
    }

    @Override
    public List<FillInBlank> findAllFillInBlanksByLevelId(Long levelId){
        return fillInBlankRepository.findAllFillInBlanksByLevelId(levelId);
    }
}
