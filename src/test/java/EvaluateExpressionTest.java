import leetcode.jan.EvaluateExpression;
import org.junit.Test;

public class EvaluateExpressionTest {

    @Test
    public void testInfixToPostfix(){
        EvaluateExpression evaluateExpression = new EvaluateExpression();
        String postFix = evaluateExpression.covertToPostFix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println(postFix);
        assert postFix.equals("abcd^e-fgh*+^*+i-");
    }
}
