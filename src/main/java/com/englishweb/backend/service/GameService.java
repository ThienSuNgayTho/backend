package com.englishweb.backend.service;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.entity.WADTO;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.repository.WAOptionRepository;
import com.englishweb.backend.repository.WAQuestionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface GameService {
    // ------------------------Questions--------------------------------

    List<WAQuestions> getAllQuestions();

    List<WAQuestions> findAllByLessonId2(int lessonid);

    void saveQuestions(String questionText, int lessonid);

    void deleteQuestionsById(Long questionId); // delete question by id

    WAQuestions findQuestionsById(Long questionId); // find question by id

    void updateQuestions(WAQuestions question);

    // ------------------------Options--------------------------------

    void saveOptions(Long optionId, boolean isCorrect, String optionText, Long questionId);

    void deleteOptionsById(Long optionId); // delete option by id

    void updateOptions(WAOptions option);

    WAOptions findOptionsByOptionId(Long optionId); // find options by question id

    List<WAOptions> findByQuestion(Long questionid); // find options by question id

    // (FlashCard)

    List<FlashCard> findAll();

    List<FlashCard> findAllByLessonId(int lessonid);

    void saveFlashCard(String frontHTML, String backHTML, int lessonId);

    void deleteFlashCardById(Long flashCardId);

    FlashCard findFlashCardById(Long flashCardId);

    void updateFlashCard(FlashCard flashCard);

    // FillInBlank

    List<FillInBlank> findAllByLevelId(Long levelid);

    List<FillInBlank> findAllFillInBlank();

    void saveFillInBlank(FillInBlank fillInBlank);

    void saveFillInBlankByLevel(String question, String answer, Long levelId);

    void deleteFillInBlank(Long id);

    FillInBlank findFillInBlanksById(Long id);

    List<FillInBlank> findAllFillInBlanksByLevelId(Long levelId);
}
