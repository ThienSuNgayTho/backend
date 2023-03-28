package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.entity.WADTO;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.repository.WAOptionRepository;
import com.englishweb.backend.repository.WAQuestionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public interface GameService {

    List<WAQuestions> getAllQuestions();

    List<WAQuestions> findAllByLevelId(Long levelid);

    List<WAOptions> findByQuestion(Long questionid);

    void saveQuestions(Long questionId, String questionText, Long levelId);

    void saveOptions(Long optionId, boolean isCorrect, String optionText, Long questionId);

    void deleteQuestionsById(Long questionId); // delete question by id

    WAQuestions findQuestionsById(Long questionId); // find question by id

    void updateQuestions(WAQuestions question);

    // other methods (FlashCard)

    List<FlashCard> findAll();

    List<FlashCard> findAllByLessonId(int lessonid);

    void saveFlashCard(String frontHTML, String backHTML, int lessonId);

    void deleteFlashCardById(Long flashCardId);

    FlashCard findFlashCardById(Long flashCardId);

    void updateFlashCard(FlashCard flashCard);

}
