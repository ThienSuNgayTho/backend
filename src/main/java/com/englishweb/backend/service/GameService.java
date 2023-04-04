package com.englishweb.backend.service;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.FlashCardDTO;


import java.util.List;


public interface GameService {
    List<FlashCard> findAll();

    List<FlashCard> findAllByLessonId(int lessonid);

    List<FillInBlank> findAllByLevelId(Long levelid);

    List<FillInBlank> findAllFillInBlank();

    void saveFillInBlank(FillInBlank fillInBlank);

    void saveFillInBlankByLevel(String question, String answer, Long levelId);

    void deleteFillInBlank(Long id);
 
    FillInBlank findFillInBlanksById(Long id);
    
    void saveFlashCard(String frontHTML, String backHTML, int lessonId);

    void deleteFlashCardById(Long flashCardId);

    FlashCard findFlashCardById(Long flashCardId);

    void updateFlashCard(FlashCardDTO flashCard);

    List<FillInBlank> findAllFillInBlanksByLevelId(Long levelId);
}
