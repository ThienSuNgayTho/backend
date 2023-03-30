package com.englishweb.backend.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.englishweb.backend.entity.Course;
import com.englishweb.backend.entity.CourseDTO;
import com.englishweb.backend.entity.Level;
import com.englishweb.backend.entity.User;
import com.englishweb.backend.repository.CourseRepository;
import com.englishweb.backend.service.CloudinaryService;
import com.englishweb.backend.service.CourseService;
// import com.englishweb.backend.service.ImageService;
import com.englishweb.backend.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @Autowired
    CloudinaryService cloudinaryService;

    // @Autowired
    // ImageService imageService;

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/saveCourse/{teacherId}")
    ResponseEntity<?> saveCourse(
            @RequestParam("courseName") String courseName,
            @RequestParam("descriptions") String descriptions,
            @RequestParam("payment") int payment,
            @RequestParam("levelId") int levelId,
            @RequestPart("multipartFile") MultipartFile multipartFile,
            @PathVariable(name = "teacherId") int teacherId) throws IOException {
        Map result = cloudinaryService.uploadImage(multipartFile);
        courseService.saveCourse(courseName, descriptions, (String) result.get("url"), payment, levelId,
                (String) result.get("public_id"), teacherId);
        courseRepository.flush();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/findCourse/{courseId}")
    Course findCourseById(@PathVariable(name = "courseId") int courseId) {
        return courseService.findCourseById(courseId);
    }

    @GetMapping("/findCourseByTeacherId/{teacherId}")
    List<CourseDTO> findCourseByTeacherId(@PathVariable(name = "teacherId") int teacherId) {
        List<Course> courses = courseService.findCourseByTeacherId(teacherId);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(course.getCourseID(), course.getCourseName(), course.getDescriptions(),
                    course.getImages(), course.getPayment(), course.getLevel().getLevelId(),
                    course.getTeacher().getUserId()));
        }
        return courseDTOs;
    }

    @GetMapping("/findCourseByLevelId/{levelId}")
    List<CourseDTO> findCourseByLevelId(@PathVariable(name = "levelId") int levelId) {
        List<Course> courses = courseService.findCourseByLevelId(levelId);
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(course.getCourseID(), course.getCourseName(), course.getDescriptions(),
                    course.getImages(), course.getPayment(), course.getLevel().getLevelId(),
                    course.getTeacher().getUserId()));
        }
        return courseDTOs;
    }

    @GetMapping("/loadCourse")
    List<CourseDTO> loadCourse() {
        List<Course> courses = courseService.findAllCourse();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            courseDTOs.add(new CourseDTO(course.getCourseID(), course.getCourseName(), course.getDescriptions(),
                    course.getImages(), course.getPayment(), course.getLevel().getLevelId(),
                    course.getTeacher().getUserId()));
        }
        return courseDTOs;
    }

    @PutMapping("/updateCourse/{courseId}/{teacherId}")
    void updateCourse(
            @RequestParam("courseName") String courseName,
            @RequestParam("descriptions") String descriptions,
            @RequestParam("payment") int payment,
            @RequestParam("levelId") int levelId,
            @RequestParam(value = "multipartFile", required = false) MultipartFile multipartFile,
            @PathVariable(name = "courseId") int courseId,
            @PathVariable(name = "teacherId") int teacherId) throws IOException {
        Course courseUpdate = courseService.findCourseById(courseId);
        // System.out.println("image"+courseUpdate.getImages());
        User teacher = userService.findUserById(teacherId);
        Level level = new Level();
        level.setLevelId(levelId);

        courseUpdate.setCourseName(courseName);
        courseUpdate.setDescriptions(descriptions);
        courseUpdate.setPayment(payment);
        courseUpdate.setLevel(level);
        courseUpdate.setTeacher(teacher);
        if (multipartFile != null) {
            Map result = cloudinaryService.deleteImage(courseUpdate.getPid());
            result = cloudinaryService.uploadImage(multipartFile);
            courseUpdate.setImages((String) result.get("url"));
            courseUpdate.setPid((String) result.get("public_id"));
        }
        courseService.updateCourse(courseUpdate);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    void deleteCourse(@PathVariable (name = "courseId") int courseId){
        courseService.deleteCourse(courseId);
    }
}
