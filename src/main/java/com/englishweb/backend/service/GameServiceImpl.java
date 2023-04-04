package com.englishweb.backend.service;

import java.util.List;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.WADTO;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.repository.FillInBlankRepository;
import com.englishweb.backend.entity.FlashCardDTO;
import com.englishweb.backend.repository.FlashCardRepository;
import com.englishweb.backend.repository.WAOptionRepository;
import com.englishweb.backend.repository.WAQuestionRepository;

import jakarta.transaction.Transactional;

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
    @Autowired
    FillInBlankRepository fillInBlankRepository;

    // FlashCard Game
    @Override
    public List<FlashCard> findAll() {
        return flashCardRepository.findAll();
    }

    @Override
    public List<FlashCard> findAllByLessonId(int lessonid) {
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

    // ------------------------------------------------
    // Fill In Blank Game
    @Override
    public List<FillInBlank> findAllByLevelId(Long levelid) {
        return fillInBlankRepository.findAllByLevelId(levelid);
    }

    @Override
    public List<FillInBlank> findAllFillInBlank() {
        return fillInBlankRepository.findAll();
    }

    @Override
    public void saveFillInBlank(FillInBlank fillInBlank) {
        fillInBlankRepository.save(fillInBlank);
    }

    @Override
    public void deleteFillInBlank(Long id) {
        fillInBlankRepository.deleteById(id);
    }

    @Override
    public FillInBlank findFillInBlanksById(Long id) {
        return fillInBlankRepository.findById(id).orElseThrow(() -> new RuntimeException("FillInBlank not found"));
    }


    
    @Transactional
    @Override
    public void saveFillInBlankByLevel(String question, String answer, Long levelId){
        fillInBlankRepository.saveFillInBlankByLevel(question, answer, levelId);
    }

    @Override
    public List<FillInBlank> findAllFillInBlanksByLevelId(Long levelId) {
        return fillInBlankRepository.findAllFillInBlanksByLevelId(levelId);
    }

    // ------------------------------------------------
    // Word Association Game
    // Questions
    @Transactional
    @Override
    public void saveQuestions(String questionText, int lessonid) {
        questionRepository.saveQuestions( questionText, lessonid);
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

    @Override
    public List<WAQuestions> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<WAQuestions> findAllByLessonId2(int lessonid) {
        return questionRepository.findAllByLessonId2(lessonid);
    }

    // ------------------------------------------------
    // Options
    @Transactional
    @Override
    public void saveOptions(Long optionId, boolean isCorrect, String optionText, Long questionId) {
        optionRepository.saveOptions(optionId, isCorrect, optionText, questionId);
    }

    @Override
    public WAOptions findOptionsByOptionId(Long optionId) {
        return optionRepository.findById(optionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid option Id:" + optionId));
    }

    @Override
    public List<WAOptions> findByQuestion(Long questionid) {
        return optionRepository.findByQuestion(questionid);
    }

    @Override
    public void deleteOptionsById(Long optionId) {
        optionRepository.deleteById(optionId);
    }

    @Override
    public void updateOptions(WAOptions option) {
        optionRepository.save(option);
    }

}
