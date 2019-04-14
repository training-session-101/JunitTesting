package unittest.testdoubles;

import org.junit.Test;
import unittest.repository.Repository;
import unittest.service.DataService;

import static org.junit.Assert.assertEquals;

public class DataServiceUnitTestWithFakeObjects {

    private Repository<String> fakeRepository = new Repository<String>() {
        public String object;

        @Override
        public void save(String object) {
            this.object = object;
        }

        @Override
        public String load() {
            return object;
        }
    };

    private DataService testee = new DataService(fakeRepository);

    @Test
    public void testSaveAndLoad_WithFake() {
        // Given
        String toSave = "some string";

        // When
        String loaded = testee.saveAndLoad(toSave);

        // Then
        assertEquals(toSave, loaded);
    }
}
