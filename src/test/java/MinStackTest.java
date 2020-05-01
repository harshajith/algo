import leetcode.april.MinStack;
import org.junit.Before;
import org.junit.Test;

public class MinStackTest {
    MinStack minStack;
    @Before
    public void setUp(){
        minStack = new MinStack();
    }

    @Test
    public void testMinStackPush(){
        minStack.push(-2);
        minStack.push(-4);
        minStack.push(2);
        assert minStack.top() == 2;
        minStack.pop();
        assert minStack.getMin() == -4;
    }

}
