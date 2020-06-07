package permutation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class StringPermutationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void TestMethodOne_ValidStrings_ShouldPass()
    {
            assertTrue(StringPermutation.methodOne("dog", "god"));
    }
}
