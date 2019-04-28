package unittest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
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

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void shouldReturnOkStatus() throws Exception{
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/courses").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAllCourses_whenGetAllCoursesIsCalled() throws Exception{
        String expectedResponse ="[" +
                "  {" +
                "    \"courseId\":1," +
                "    \"courseName\":\"Course 1\"" +
                "  }]";
        when(courseService.getAllCourses()).thenReturn(singletonList(new CourseDetails(1, "Course 1")));
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/courses").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(content().json(expectedResponse)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void shouldReturnOkStatus_withAllCourses() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/courses/v2/1,2").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllCourses() throws Exception {
        when(courseService.getCoursesByIds(1,2)).thenReturn(asList(new CourseDetails(1,"Course1"), new CourseDetails(2,"Course2")));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/courses/v2/1,2").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("[" +
                "    {" +
                "        \"courseId\": 1," +
                "        \"courseName\": \"Course1\"" +
                "    }," +
                "    {" +
                "        \"courseId\": 2," +
                "        \"courseName\": \"Course2\"" +
                "    }" +
                "]"));
    }

}
