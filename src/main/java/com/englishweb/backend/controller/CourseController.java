package com.englishweb.backend.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.englishweb.backend.entity.Course;
import com.englishweb.backend.entity.CourseDTO;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.service.CourseService;
import com.englishweb.backend.service.UserService;


@RestController
@CrossOrigin("http://localhost:3000")
public class CourseController {
    
    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @PostMapping("/saveCourse/{levelId}/{teacherId}")
    void saveCourse(@RequestBody Course course , @PathVariable (name = "levelId") int levelId , @PathVariable (name = "teacherId") int teacherId){
        courseService.saveCourse(course.getCourseName(), course.getDescriptions(), course.getImages(), course.getPayment(), levelId, teacherId);
    }

    @GetMapping("/findCourse/{courseId}")
    Course findCourseById (@PathVariable (name = "courseId") int courseId){
        return courseService.findCourseById(courseId);
    }

    @GetMapping("/findCourseByTeacherId/{teacherId}")
    List<CourseDTO> findCourseByTeacherId (@PathVariable (name = "teacherId") int teacherId){
        List<Course> courses = courseService.findCourseByTeacherId(teacherId);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(course.getCourseID(), course.getCourseName(), course.getDescriptions(), course.getImages(), course.getPayment(), course.getLevel().getLevelId(), course.getTeacher().getUserId()));
        }
        return courseDTOs;
    }

    @GetMapping("/findCourseByLevelId/{levelId}")
    List<CourseDTO> findCourseByLevelId (@PathVariable (name = "levelId") int levelId){
        List<Course> courses = courseService.findCourseByLevelId(levelId);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(course.getCourseID(), course.getCourseName(), course.getDescriptions(), course.getImages(), course.getPayment(), course.getLevel().getLevelId(), course.getTeacher().getUserId()));
        }
        return courseDTOs;
    }

    @GetMapping("/loadCourse")
    List<CourseDTO> loadCourse(){
        List<Course> courses = courseService.findAllCourse();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(course.getCourseID(), course.getCourseName(), course.getDescriptions(), course.getImages(), course.getPayment(), course.getLevel().getLevelId(), course.getTeacher().getUserId()));
        }
        return courseDTOs;
    }

    @PutMapping("/updateCourse/{courseId}/{teacherId}")
    void updateCourse(@RequestBody Course course , @PathVariable (name = "courseId") int courseId, @PathVariable (name = "teacherId") int teacherId ){
        Course courseUpdate = courseService.findCourseById(courseId);
        User teacher = userService.findUserById(teacherId);
        courseUpdate.setCourseName(course.getCourseName());
        courseUpdate.setDescriptions(course.getDescriptions());
        courseUpdate.setImages(course.getImages());
        courseUpdate.setPayment(course.getPayment());
        courseUpdate.setLevel(course.getLevel());
        courseUpdate.setTeacher(teacher);
        courseService.updateCourse(courseUpdate);
    }
}
