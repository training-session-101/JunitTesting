package unittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unittest.dto.CourseDetails;
import unittest.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDetails> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/v2/{id}")
    public List<CourseDetails> getAllCoursesById(@PathVariable("id") Integer... ids){
        return courseService.getCoursesByIds(ids);
    }
}
