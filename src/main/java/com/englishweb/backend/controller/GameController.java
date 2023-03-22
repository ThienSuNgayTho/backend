package com.englishweb.backend.controller;

import com.englishweb.backend.entity.FlashCard;
import com.englishweb.backend.entity.User;
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
    List<FlashCard> loadFlashCard(){
        return gameService.findAll();
    }

    @GetMapping("/loadFlashCard/{lessonid}")
    List<FlashCardDTO> loadFlashCardByLessonID(@PathVariable (name = "lessonid") int lessonId){
        List<FlashCard> flashCards = gameService.findAllByLessonId(lessonId);
        List<FlashCardDTO> flashCardDTOs = new ArrayList<>();
        for (FlashCard flashCard : flashCards) {
            flashCardDTOs.add(new FlashCardDTO(flashCard.getFlashCardId(), flashCard.getFrontHTML(), flashCard.getBackHTML(), flashCard.getLesson().getLessonId()));
        }
        return flashCardDTOs;
    }
    
    @PostMapping("/saveFlashCard/{lessonId}")
        void saveFlashCard(@PathVariable (name = "lessonId") int lessonId , @RequestBody FlashCard flashCard){
            gameService.saveFlashCard(flashCard.getFrontHTML(), flashCard.getBackHTML(), lessonId);
        }
        
    @GetMapping("/findFlashCard/{flashCardId}")
    FlashCard findFlashCardById (@PathVariable (name = "flashCardId") Long flashCardId){
        return gameService.findFlashCardById(flashCardId);
    } 
        
    @GetMapping("/findFlashCardByLessonId/{lessonId}")
    List<FlashCardDTO> findFlashCardByLessonId (@PathVariable (name = "lessonId") int lessonId){
        List<FlashCard> flashCards = gameService.findAllByLessonId(lessonId);
        List<FlashCardDTO> flashCardDTOs = new ArrayList<>();
        for (FlashCard flashCard : flashCards) {
            flashCardDTOs.add(new FlashCardDTO(flashCard.getFlashCardId(), flashCard.getFrontHTML(), flashCard.getBackHTML(), flashCard.getLesson().getLessonId()));
        }
        return flashCardDTOs;
    }

    @PutMapping("/updateFlashCard/{flashCardId}")
        void updateFlashCard(@PathVariable (name = "flashCardId") Long flashCardId, @RequestBody FlashCard flashCard){
            FlashCard flashCardToUpdate = gameService.findFlashCardById(flashCardId);
            flashCardToUpdate.setFrontHTML(flashCard.getFrontHTML());
            flashCardToUpdate.setBackHTML(flashCard.getBackHTML());
            flashCardToUpdate.setLesson(flashCard.getLesson());
            gameService.updateFlashCard(flashCardToUpdate);
        }
    
    @DeleteMapping("/deleteFlashCard/{flashCardId}")
        void deleteFlashCardById (@PathVariable (name = "flashCardId") Long flashCardId){
            gameService.deleteFlashCardById(flashCardId);
        }
}
