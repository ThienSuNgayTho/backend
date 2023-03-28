package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.WADTO;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.repository.FlashCardRepository;
import com.englishweb.backend.repository.WAOptionRepository;
import com.englishweb.backend.repository.WAQuestionRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public void saveFlashCard(String frontHTML, String backHTML, int lessonId) {
        flashCardRepository.saveFlashCard(frontHTML, backHTML, lessonId);
        ;
    }

    @Override
    public void deleteFlashCardById(Long flashCardId) {
        flashCardRepository.deleteById(flashCardId);
    }

    @Override
    public FlashCard findFlashCardById(Long flashCardId) {
        return flashCardRepository.findById(flashCardId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid flashcard Id:" + flashCardId));
    }

    @Override
    public void updateFlashCard(FlashCard flashCard) {
        flashCardRepository.save(flashCard);
    }

    @Transactional
    @Override
    public void saveQuestions(Long questionId, String questionText, Long levelId) {
        questionRepository.saveQuestions(questionId, questionText, levelId);
    }

    @Transactional
    @Override
    public void saveOptions(Long optionId, boolean isCorrect, String optionText, Long questionId) {
        optionRepository.saveOptions(optionId, isCorrect, optionText, questionId);
    }

    @Override
    public void deleteQuestionsById(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public WAQuestions findQuestionsById(Long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + questionId));
    }
    
    @Override
    public void updateQuestions(WAQuestions question) {
        questionRepository.save(question);
    }
 
}
