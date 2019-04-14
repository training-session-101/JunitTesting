package unittest.deepstubs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class DeepStubDependentTest {
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private DeepStubDependent deepStubDependent;

    @Test
    public void testMethodUnderTest() {
        DeepStubs deepStubExample = new DeepStubs();
        //deepStubExample.setDeepStubDependent(deepStubDependent);
        given(deepStubDependent.getDeepStubDependentDependent().getMessage(anyString())).willReturn("some text");
        String output = deepStubExample.methodUnderTest("test");
        assertEquals("some text", output);
    }

}