package com.englishweb.backend.controller;

import com.englishweb.backend.entity.*;
import com.englishweb.backend.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/loadFlashCard")
    List<FlashCard> loadFlashCard(){
        return gameService.findAll();
    }

    @GetMapping("/loadFlashCard/{lessonid}")
    List<FlashCardDTO> loadFlashCardByLessonID(@PathVariable (name = "lessonid") int lessonId){
        List<FlashCard> flashCards = gameService.findAllByLessonId(lessonId);
        List<FlashCardDTO> flashCardDTOs = new ArrayList<>();
        for (FlashCard flashCard : flashCards) {
            flashCardDTOs.add(new FlashCardDTO(flashCard.getFlashCardId(), flashCard.getFrontHTML(), flashCard.getBackHTML()));
        }
        return flashCardDTOs;
    }

    @GetMapping("/loadFillInBlank/{levelid}")
    List<FillInBlankDTO> loadFillInBlankByLevelID(@PathVariable (name = "levelid") Long levelId){
        List<FillInBlank> fillInBlanks = gameService.findAllByLevelId(levelId);
        List<FillInBlankDTO> fillInBlankDTOS = new ArrayList<>();
        for (FillInBlank fillInBlank : fillInBlanks) {
            fillInBlankDTOS.add(new FillInBlankDTO(fillInBlank.getId(), fillInBlank.getQuestion(), fillInBlank.getAnswer()));
        }
        return fillInBlankDTOS;
    }


}
