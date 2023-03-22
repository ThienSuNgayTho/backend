package com.englishweb.backend.service;

import com.englishweb.backend.entity.FillInBlank;
import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;

import java.util.List;

public interface GameService {
    List<FlashCard> findAll();
    List<FlashCard> findAllByLessonId(int lessonid);

    List<FillInBlank> findAllByLevelId(Long levelid);

    List<FillInBlank> findAllFillInBlank();

    void saveFillInBlank(FillInBlank fillInBlank);

    void deleteFillInBlank(Long id);
 
    FillInBlank findFillInBlanksById(Long id);

    
}
