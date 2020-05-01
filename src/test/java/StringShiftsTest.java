import leetcodeApril.StringShifts;
import org.junit.Before;
import org.junit.Test;

public class StringShiftsTest {
    StringShifts stringShifts;

    @Before
    public void setUp(){
        stringShifts = new StringShifts();

    }

    @Test
    public void testStringShift1(){
        int[][] shift = new int[][]{
                {0,1},
                {1,2}
        };

        String s = "abc";
        String result = stringShifts.stringShift(s, shift);
        assert result.equals("cab");
    }

    @Test
    public void testStringShift2(){
        int[][] shift = new int[][]{
                {1,1},
                {1,1},
                {0,2},
                {1,3}
        };

        String s = "abcdefg";
        String result = stringShifts.stringShift(s, shift);
        assert result.equals("efgabcd");
    }

    @Test
    public void testStringShift3(){
        int[][] shift = new int[][]{
                {1,8},
                {1,4},
                {1,3},
                {1,6},
                {0,6},
                {1,4},
                {0,2},
                {1,1}
        };

        String s = "yisxjwry";
        String result = stringShifts.stringShift(s, shift);
    }
}
