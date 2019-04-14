package unittest.testdoubles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import unittest.repository.Repository;
import unittest.service.DataService;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class DataServiceUnitTestWithCaptor {

    @InjectMocks
    DataService testee;

    @Mock
    private Repository<String> mockRepository;

    @Test
    public void test() {
        // Given
        //Repository<String> mockRepository = Mockito.mock(Repository.class);
        //DataService testee = new DataService(mockRepository);

        String saveData = "some string";

        Mockito.when(mockRepository.load()).thenReturn("some string");
        // When
        String loaded = testee.saveAndLoad(saveData);


        // loaded will be null, the test will fail
        assertEquals(saveData, loaded);
    }
}
