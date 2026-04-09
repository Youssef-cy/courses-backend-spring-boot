package com.example.course.Mapping;


import com.example.course.DTO.CourseReq;
import com.example.course.DTO.CourseRes;
import com.example.course.Entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CourseReq categoryRequest);
    CourseRes toResponse(Course category);
    List<CourseRes> toResponses(List<Course>categories);
}
