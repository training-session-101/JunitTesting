package unittest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import unittest.dto.CourseDetails;
import unittest.service.CourseService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerWithFakes {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void shouldReturnOkStatus() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/courses").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAllCourses_whenGetAllCoursesIsCalled() throws Exception {
        String expectedResponse ="[" +
                "  {" +
                "    \"courseId\":2," +
                "    \"courseName\":\"Course2\"" +
                "  }]";
        //when(courseService.getAllCourses()).thenReturn(Arrays.asList(new CourseDetails(1,"Course 1")));
        when(courseService.getAllCourses()).thenReturn(new CourseServiceFake().getAllCourseDetails());
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/courses").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(content().json(expectedResponse)).andExpect(status().isOk()).andReturn();
    }

    class CourseServiceFake {

        public List<CourseDetails> getAllCourseDetails(){
            return Arrays.asList(new CourseDetails(2,"Course2"));
        }


    }

}
