package unittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unittest.data.Course;
import unittest.dto.CourseDetails;
import unittest.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDetails> getAllCourses(){
        List<Course> courses =courseRepository.findAll();
        return courses.stream().map(course-> new CourseDetails(course.getId(),course.getCoureseName())).collect(Collectors.toList());
    }
}
