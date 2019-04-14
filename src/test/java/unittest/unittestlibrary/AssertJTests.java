package unittest.unittestlibrary;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTests {

    //Writing Asserts with single import and more readable format
    @Test
    public void testAsserts(){
        List<Integer> numbers = Arrays.asList(12,10,13);
        assertThat(numbers).hasSize(3).contains(12,10).containsExactlyInAnyOrder(12,13,10);
        assertThat("ABCDE").contains("BCD").startsWith("ABC").endsWith("DE");
    }
}