package com.englishweb.backend.controller;

import com.englishweb.backend.entity.*;
import com.englishweb.backend.service.*;

import jakarta.persistence.criteria.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.backend.entity.LessonDTO;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:3000")
public class LessonController {
    @Autowired
    LessonService lessonService;

    @GetMapping("/loadLesson")
    List<Lesson> loadLesson() {
        return lessonService.findAll();
    }

    @GetMapping("/loadLesson/{courseid}")
    List<LessonDTO> loadLessonByCourseID(@PathVariable(name = "courseid") int courseId) {
        List<Lesson> lessons = lessonService.findAllByCourseId(courseId);
        List<LessonDTO> lessonDTOs = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonDTOs.add(new LessonDTO(lesson.getLessonId(), lesson.getLessonName(), lesson.getContent(),
                    lesson.getCourse().getCourseID(), lesson.getPdfFile()));
        }
        return lessonDTOs;
    }

    @DeleteMapping("/deleteLesson/{id}")
    void deleteLesson(@PathVariable(name = "id") int id) {
        lessonService.deleteLessonById(id);
    }

    @PostMapping("/saveLesson/{courseId}")
    void saveLesson(@PathVariable(name = "courseId") int courseId, @RequestBody Lesson lesson) {
        lessonService.saveCourse(lesson.getLessonName(), lesson.getContent(), courseId, lesson.getPdfFile());
    }

    @PutMapping("/updateLesson/{lessonId}")
    void updateLesson(@PathVariable(name = "lessonId") int lessonId, @RequestBody Lesson lesson) {
        Lesson lessonUpdate = lessonService.findLessonById(lessonId);
        lessonUpdate.setLessonName(lesson.getLessonName());
        lessonUpdate.setContent(lesson.getContent());
        lessonUpdate.setPdfFile(lesson.getPdfFile());
        lessonService.updateLesson(lessonUpdate);
    }

    @GetMapping("/findLesson/{lessonId}")
    Lesson findLessonById(@PathVariable(name = "lessonId") int lessonId) {
        return lessonService.findLessonById(lessonId);
    }

    
}
