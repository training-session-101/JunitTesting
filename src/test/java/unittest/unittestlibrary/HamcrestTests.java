package unittest.unittestlibrary;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

public class HamcrestTests {

    //Writing more readable asserts
    @Test
    public void testAsserts(){
        List<Integer> numbers = Arrays.asList(12,10,13);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, contains(12,10,13));
        assertThat(numbers, containsInAnyOrder(12,13,10));

        assertThat(numbers.get(1),greaterThanOrEqualTo(10));
        assertThat("ABCDE", startsWith("ABC"));
        assertThat("ABCDE", endsWith("CDE"));

    }
}
