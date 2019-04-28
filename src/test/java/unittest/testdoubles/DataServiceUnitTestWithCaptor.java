package unittest.testdoubles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import unittest.repository.Repository;
import unittest.service.DataService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class DataServiceUnitTestWithCaptor {

    @InjectMocks
    DataService dataService;

    @Mock
    private Repository<String> mockRepository;

    @Test
    public void test() {
        dataService.saveAndLoad("Something1");

        ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
        verify(mockRepository,times(1)).save(captor.capture());
       //verify(mockRepository,times(1)).load();

        String parameter = captor.getValue();

        assertThat("Something1a").isEqualTo(parameter);

    }
}
