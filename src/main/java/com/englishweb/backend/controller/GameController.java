package com.englishweb.backend.controller;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.entity.WADTO;
import com.englishweb.backend.entity.WAOptions;
import com.englishweb.backend.entity.WAQuestions;
import com.englishweb.backend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.englishweb.backend.entity.FlashCardDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/loadFlashCard")
    List<FlashCard> loadFlashCard() {
        return gameService.findAll();
    }

    @GetMapping("/loadFlashCard/{lessonid}")
    List<FlashCardDTO> loadFlashCardByLessonID(@PathVariable(name = "lessonid") int lessonId) {
        List<FlashCard> flashCards = gameService.findAllByLessonId(lessonId);
        List<FlashCardDTO> flashCardDTOs = new ArrayList<>();
        for (FlashCard flashCard : flashCards) {
            flashCardDTOs.add(new FlashCardDTO(flashCard.getFlashCardId(), flashCard.getFrontHTML(),
                    flashCard.getBackHTML(), flashCard.getLesson().getLessonId()));
        }
        return flashCardDTOs;
    }

    @PostMapping("/saveFlashCard/{lessonId}")
    void saveFlashCard(@PathVariable(name = "lessonId") int lessonId, @RequestBody FlashCard flashCard) {
        gameService.saveFlashCard(flashCard.getFrontHTML(), flashCard.getBackHTML(), lessonId);
    }

    @GetMapping("/findFlashCard/{flashCardId}")
    FlashCard findFlashCardById(@PathVariable(name = "flashCardId") Long flashCardId) {
        return gameService.findFlashCardById(flashCardId);
    }

    @GetMapping("/findFlashCardByLessonId/{lessonId}")
    List<FlashCardDTO> findFlashCardByLessonId(@PathVariable(name = "lessonId") int lessonId) {
        List<FlashCard> flashCards = gameService.findAllByLessonId(lessonId);
        List<FlashCardDTO> flashCardDTOs = new ArrayList<>();
        for (FlashCard flashCard : flashCards) {
            flashCardDTOs.add(new FlashCardDTO(flashCard.getFlashCardId(), flashCard.getFrontHTML(),
                    flashCard.getBackHTML(), flashCard.getLesson().getLessonId()));
        }
        return flashCardDTOs;
    }

    @PutMapping("/updateFlashCard/{flashCardId}")
    void updateFlashCard(@PathVariable(name = "flashCardId") Long flashCardId, @RequestBody FlashCard flashCard) {
        FlashCard flashCardToUpdate = gameService.findFlashCardById(flashCardId);
        flashCardToUpdate.setFrontHTML(flashCard.getFrontHTML());
        flashCardToUpdate.setBackHTML(flashCard.getBackHTML());
        flashCardToUpdate.setLesson(flashCard.getLesson());
        gameService.updateFlashCard(flashCardToUpdate);
    }

    @DeleteMapping("/deleteFlashCard/{flashCardId}")
    void deleteFlashCardById(@PathVariable(name = "flashCardId") Long flashCardId) {
        gameService.deleteFlashCardById(flashCardId);
    }

    @GetMapping("/word/{levelid}")
    List<WADTO> loadWordByLevelID(@PathVariable(name = "levelid") Long levelId) {
        List<WAQuestions> wadto = gameService.findAllByLevelId(levelId);
        List<WADTO> WADTOs = new ArrayList<>();

        for (WAQuestions waQuestion : wadto) {
            List<WAOptions> waop = gameService.findByQuestion(waQuestion.getId());
            WADTOs.add(
                    new WADTO(waQuestion.getId(), waQuestion.getQuestionText(),
                            waop));
        }
        return WADTOs;
    }

    @PostMapping("/saveQuestions/{levelid}")
    void saveQuestions(@PathVariable(name = "levelid") Long levelId, @RequestBody WADTO wadto) {
        gameService.saveQuestions(levelId, null, levelId);
    }

    @PostMapping("/saveOptions/{questionid}")
    void saveOptions(@PathVariable(name = "questionid") Long questionId, @RequestBody WADTO wadto) {
        gameService.saveOptions(questionId, false, null, questionId);
    }

    @DeleteMapping("/deleteQuestionsById/{questionid}")
    void deleteQuestionsById(@PathVariable(name = "questionid") Long questionId) {
        gameService.deleteQuestionsById(questionId);
    }

    @PutMapping("/updateQuestions/{questionid}")
    void updateQuestions(@PathVariable(name = "questionid") Long questionId, @RequestBody WAQuestions question) {
        WAQuestions questionToUpdate = gameService.findQuestionsById(questionId);
        questionToUpdate.setQuestionText(question.getQuestionText());
        questionToUpdate.setLevelId(question.getLevelId());
        gameService.updateQuestions(question);
    }

    @GetMapping("/findQuestionsById/{questionid}")
    WAQuestions findQuestionsById(@PathVariable(name = "questionid") Long questionId) {
        WAQuestions question = gameService.findQuestionsById(questionId);
        return question;
    }

}