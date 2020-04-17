import leetcode30Challenge.ValidParenthesisString;
import org.junit.Before;
import org.junit.Test;

public class ValidParenthesisStringTest {

    ValidParenthesisString validParenthesisString;

    @Before
    public void setUp(){
        validParenthesisString = new ValidParenthesisString();
    }

    @Test
    public void testCase1(){
        String a = "()";
        boolean result = validParenthesisString.checkValidString(a);
        assert result == true;
    }


    @Test
    public void testCase2(){
        String a = "(*)";
        boolean result = validParenthesisString.checkValidString(a);
        assert result == true;
    }

    @Test
    public void testCase3(){
        String a = "(*))";
        boolean result = validParenthesisString.checkValidString(a);
        assert result == true;
    }

}
