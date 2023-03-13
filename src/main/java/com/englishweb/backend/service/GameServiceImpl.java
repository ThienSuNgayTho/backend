package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.repository.FillInBlankRepository;
import com.englishweb.backend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

    @Autowired
    FillInBlankRepository fillInBlankRepository;

    @Override
    public List<FlashCard> findAll() {
    return gameRepository.findAll();
    }

    @Override
    public List<FlashCard> findAllByLessonId(int lessonid){
        return gameRepository.findAllByLessonId(lessonid);
    }

    @Override
    public List<FillInBlank> findAllByLevelId(Long levelid){
        return fillInBlankRepository.findAllByLevelId(levelid);
    }
}
