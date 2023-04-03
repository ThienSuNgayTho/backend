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

    // FlashCard Game
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

    // Word Association Game
    @GetMapping("/word/{lessonid}")
    List<WADTO> loadWordByLessonID(@PathVariable(name = "lessonid")  int lessonId) {
        List<WAQuestions> wadto = gameService.findAllByLessonId2(lessonId);
        List<WADTO> WADTOs = new ArrayList<>();

        for (WAQuestions waQuestion : wadto) {
            List<WAOptions> waop = gameService.findByQuestion(waQuestion.getId());
            WADTOs.add(
                    new WADTO(waQuestion.getId(), waQuestion.getQuestionText(),
                            waop, waQuestion.getLesson().getLessonId()));
        }
        return WADTOs;
    }

    // ------------------------Questions--------------------------------
    @PostMapping("/saveQuestions/{lessonid}")
    void saveQuestions(@PathVariable(name = "lessonid")  int lessonId, @RequestBody WADTO wadto) {
        gameService.saveQuestions( wadto.getQuestionText(), lessonId);
    }

    @DeleteMapping("/deleteQuestionsById/{questionid}")
    void deleteQuestionsById(@PathVariable(name = "questionid") Long questionId) {
        gameService.deleteQuestionsById(questionId);
    }

    @PutMapping("/updateQuestions/{questionid}")
    void updateQuestions(@PathVariable(name = "questionid") Long questionId, @RequestBody WAQuestions question) {
        WAQuestions questionToUpdate = gameService.findQuestionsById(questionId);
        questionToUpdate.setQuestionText(question.getQuestionText());
        questionToUpdate.setLesson(question.getLesson());
        gameService.updateQuestions(questionToUpdate);
    }

    @GetMapping("/findQuestionsById/{questionid}")
    WAQuestions findQuestionsById(@PathVariable(name = "questionid") Long questionId) {
        WAQuestions question = gameService.findQuestionsById(questionId);
        return question;
    }

    // ------------------------Options--------------------------------
    @PostMapping("/saveOptions/{questionid}")
    void saveOptions(@PathVariable(name = "questionid") Long questionId, @RequestBody WAOptions options) {
        gameService.saveOptions(questionId, options.getIsCorrect(), options.getOptionText() , questionId);
    }

    @DeleteMapping("/deleteOptionsById/{optionid}")
    void deleteOptionsById(@PathVariable(name = "optionid") Long optionId) {
        gameService.deleteOptionsById(optionId);
    }

    @GetMapping("/findOptionsByQuestionId/{questionid}")
    List<WAOptions> findOptionsByQuestionId(@PathVariable(name = "questionid") Long questionId) {
        List<WAOptions> options = gameService.findByQuestion(questionId);
        return options;
    }

    @GetMapping("/findOptionsByOptionId/{optionid}")
    WAOptions findOptionsByOptionId(@PathVariable(name = "optionid") Long optionId) {
        return gameService.findOptionsByOptionId(optionId);

    }

    @PutMapping("/updateOptions/{optionid}")
    void updateOptions(@PathVariable(name = "optionid") Long optionId, @RequestBody WAOptions option) {
        WAOptions optionToUpdate = gameService.findOptionsByOptionId(optionId);
        optionToUpdate.setOptionText(option.getOptionText());
        optionToUpdate.setIsCorrect(option.getIsCorrect());
        // optionToUpdate.setQuestionId(option.getQuestionId());
        gameService.updateOptions(option);

    }
}