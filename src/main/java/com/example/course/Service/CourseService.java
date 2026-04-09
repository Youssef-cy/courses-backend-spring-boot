package com.example.course.Service;


import com.example.course.DTO.CourseReq;
import com.example.course.DTO.CourseRes;
import com.example.course.Entity.Course;
import com.example.course.Mapping.CourseMapper;
import com.example.course.Repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseMapper courseMapper;

    // create course
    public CourseReq createCourse(CourseReq courseReq) {
        Course course = courseMapper.toEntity(courseReq);
        courseRepo.save(course);
        return courseReq;
    }

    // get all courses
    public List<CourseRes> getAllCourse() {
        return courseRepo.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .collect(Collectors.toList());
    }

    // GET WITH ID
    public CourseRes getCourseById(Long id) {

        Optional<Course> course = courseRepo.findById(id);
        return course.map(courseMapper::toResponse).orElse(null);

    }

    //update
    public  CourseRes updateCourse(CourseReq courseReq , Long id) {
       Optional<Course> course = courseRepo.findById(id);
       if(course.isPresent()) {
           Course course1 = course.get();
           course1.setTitle(courseReq.getTitle());
           course1.setDescription(courseReq.getDescription());
           course1.setPrice(courseReq.getPrice());
           course1.setIntroduction(courseReq.getInstructor());
           Course save = courseRepo.save(course1);
           return courseMapper.toResponse(save);
       }
       return null;
    }

    //delete
    public boolean deleteCourseById(Long id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return true;
        }

        return false;
    }
}
