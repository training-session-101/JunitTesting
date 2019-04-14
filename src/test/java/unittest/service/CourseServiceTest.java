package unittest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import unittest.data.Course;
import unittest.dto.CourseDetails;
import unittest.repository.CourseRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    @Test
    public void shouldReturnAllCourses(){
        List<CourseDetails> expectedCourses = Arrays.asList(new CourseDetails(1,"Course 1"));
        when(courseRepository.findAll()).thenReturn(Arrays.asList(new Course(1,"Course 1")));
        courseService.getAllCourses().toArray();
       assertArrayEquals(courseService.getAllCourses().toArray(), expectedCourses.toArray());
    }
}
