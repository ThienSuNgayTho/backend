package com.englishweb.backend.controller;

import com.englishweb.backend.entity.*;
import com.englishweb.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.englishweb.backend.entity.LessonDTO;

import java.util.List;
import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:3000")
public class LessonController {
    @Autowired
    LessonService lessonService;

    @GetMapping("/loadLesson")
    List<Lesson> loadLesson(){
        return lessonService.findAll();
    }

    @GetMapping("/loadLesson/{courseid}")
    List<LessonDTO> loadLessonByCourseID(@PathVariable (name = "courseid") int courseId){
        List<Lesson> lessons = lessonService.findAllByCourseId(courseId);
        List<LessonDTO> lessonDTOs = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonDTOs.add(new LessonDTO(lesson.getLessonId(), lesson.getLessonName(), lesson.getContent(), lesson.getCourse().getCourseId()));
        }
        return lessonDTOs;
    }

    @PostMapping("/saveLesson")
    void saveLesson(@RequestBody Lesson lesson){
        lessonService.saveLesson(lesson.getLessonName(), lesson.getContent(), lesson.getCourse().getCourseId());
    }

    @DeleteMapping("/deleteLesson/{id}")
    void deleteLesson(@PathVariable (name = "id") int id){
        lessonService.deleteLessonById(id);
    }

    @PostMapping("/saveLesson/{courseId}")
    void saveLesson(@PathVariable (name = "courseId") int courseId , @RequestBody Lesson lesson){
        lessonService.saveLessonByCourse(lesson.getLessonName(), lesson.getContent(), courseId);
    }

    
}
