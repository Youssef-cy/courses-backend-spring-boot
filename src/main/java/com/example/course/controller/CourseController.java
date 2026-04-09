package com.example.course.controller;


import com.example.course.DTO.CourseReq;
import com.example.course.DTO.CourseRes;
import com.example.course.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping
    public CourseReq createCourse(CourseReq courseReq) {

        return courseService.createCourse(courseReq);

    }

    @GetMapping
    public List<CourseRes> getAllCourses() {

        return courseService.getAllCourse();

    }

    @GetMapping("/{id}")
    public CourseRes getCourse( Long id) {


        return courseService.getCourseById(id);


    }

    @PutMapping("/{id}")
    public CourseRes update( Long id, CourseReq course) {

        return courseService.updateCourse(course, id);


    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {

        return courseService.deleteCourseById(id);

    }


}

