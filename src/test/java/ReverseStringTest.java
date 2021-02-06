import leetcode.jan.ReverseString;
import org.junit.Before;
import org.junit.Test;

public class ReverseStringTest {
    ReverseString reverseString;

    @Before
    public void setup(){
        reverseString = new ReverseString();
    }

    @Test
    public void testReverseString(){
        String input = "abcd";
        String expected = "dcba";
        String reversed = reverseString.reverseIteratively(input);
        assert reversed.equals(expected);
    }

    @Test
    public void testRecursively(){
        String input = "abcd";
        String expected = "dcba";
        String result = reverseString.reverseRecursively(input);
        assert result.equals(expected);
    }

}
