package com.englishweb.backend.service;

import java.util.List;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.repository.FlashCardRepository;
import com.englishweb.backend.repository.WAOptionRepository;
import com.englishweb.backend.repository.WAQuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    FlashCardRepository flashCardRepository;

    @Autowired
    private WAQuestionRepository questionRepository;

    @Autowired
    private WAOptionRepository optionRepository;

    @Override
    public List<FlashCard> findAll() {
        return flashCardRepository.findAll();
    }

    @Override
    public List<FlashCard> findAllByLessonId(int lessonid) {
        return flashCardRepository.findAllByLessonId(lessonid);
    }

    @Override
    public List<WAQuestions> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<WAQuestions> findAllByLevelId(Long levelid) {
        return questionRepository.findAllByLevelId(levelid);
    }

    @Override
    public List<WAOptions> findByQuestion(Long questionid) {
        return optionRepository.findByQuestion(questionid);
    }
}
