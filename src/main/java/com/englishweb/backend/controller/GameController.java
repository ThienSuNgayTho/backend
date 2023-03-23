package com.englishweb.backend.controller;

import com.englishweb.backend.entity.*;
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

    @GetMapping("/loadFillInBlank/{levelid}")
    List<FillInBlankDTO> loadFillInBlankByLevelID(@PathVariable (name = "levelid") Long levelId){
        List<FillInBlank> fillInBlanks = gameService.findAllByLevelId(levelId);
        List<FillInBlankDTO> fillInBlankDTOS = new ArrayList<>();
        for (FillInBlank fillInBlank : fillInBlanks) {
            fillInBlankDTOS.add(new FillInBlankDTO(fillInBlank.getId(), fillInBlank.getQuestion(), fillInBlank.getAnswer(), levelId));
        }
        return fillInBlankDTOS;
    }

    @GetMapping("/loadFillInBlank")
    List<FillInBlank> loadFillInBlank(){
        return gameService.findAllFillInBlank();
    }

    @PostMapping("/saveFillInBlank")
    void saveFillInBlank(@RequestBody FillInBlank fillInBlank){
        gameService.saveFillInBlank(fillInBlank);
    }

    @PostMapping("/saveFillInBlank/{levelId}")
    void saveFillInBlank(@PathVariable (name = "levelId") Long levelId , @RequestBody FillInBlank fillInBlank){
        gameService.saveFillInBlankByLevel(fillInBlank.getQuestion(), fillInBlank.getAnswer(), levelId);
    }

    @DeleteMapping("/deleteFillInBlank/{id}")
    void deleteFillInBlank(@PathVariable (name = "id") Long id){
        gameService.deleteFillInBlank(id);
    }

    @PutMapping("/updateFillInBlank/{id}")
    void updateFillInBlank(@PathVariable (name = "id") Long id, @RequestBody FillInBlank fillInBlank){
        FillInBlank fillInBlanksToUpdate = gameService.findFillInBlanksById(id);
        fillInBlanksToUpdate.setQuestion(fillInBlank.getQuestion());
        fillInBlanksToUpdate.setAnswer(fillInBlank.getAnswer());
        gameService.saveFillInBlank(fillInBlanksToUpdate);
    }

    @GetMapping("/findFillInBlank/{id}")
    FillInBlank loadFillInBlankById(@PathVariable (name = "id") Long id){
        return gameService.findFillInBlanksById(id);
    }

    @GetMapping("/findFillInBlankByLevelId/{levelId}")
    List<FillInBlankDTO> findFillInBlankByLevelId (@PathVariable (name = "levelId") Long levelId){
        List<FillInBlank> fillInBlanks = gameService.findAllByLevelId(levelId);
        List<FillInBlankDTO> fillInBlankDTOS = new ArrayList<>();
        for (FillInBlank fillInBlank : fillInBlanks) {
            fillInBlankDTOS.add(new FillInBlankDTO(fillInBlank.getId(), fillInBlank.getQuestion(), fillInBlank.getAnswer(), levelId));
        }
        return fillInBlankDTOS;
    }

    @GetMapping("/findAllFillInBlankByLevelId/{levelId}")
    List<FillInBlankDTO> findAllFillInBlankByLevelId (@PathVariable (name = "levelId") Long levelId){
        List<FillInBlank> fillInBlanks = gameService.findAllFillInBlanksByLevelId(levelId);
        List<FillInBlankDTO> fillInBlankDTOS = new ArrayList<>();
        for (FillInBlank fillInBlank : fillInBlanks) {
            fillInBlankDTOS.add(new FillInBlankDTO(fillInBlank.getId(), fillInBlank.getQuestion(), fillInBlank.getAnswer(), levelId));
        }
        return fillInBlankDTOS;
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
