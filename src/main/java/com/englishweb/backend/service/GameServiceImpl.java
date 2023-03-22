package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.repository.FlashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.englishweb.backend.repository.FillInBlankRepository;

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

    
}
