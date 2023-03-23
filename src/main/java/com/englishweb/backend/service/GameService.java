package com.englishweb.backend.service;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.repository.WAOptionRepository;
import com.englishweb.backend.repository.WAQuestionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface GameService {

    List<WAQuestions> getAllQuestions();

    List<FlashCard> findAll();

    List<FlashCard> findAllByLessonId(int lessonid);

    List<WAQuestions> findAllByLevelId(Long levelid);

    List<WAOptions> findByQuestion(Long questionid);
    // other methods
}
