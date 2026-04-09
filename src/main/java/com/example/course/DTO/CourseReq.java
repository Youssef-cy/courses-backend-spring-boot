package com.example.course.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseReq {

private String title;
private String description;
private String instructor;
private Long price;
}
