package unittest.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void shouldContain3Courses(){
        assertEquals(courseRepository.findAll().size(),3);
    }

}


