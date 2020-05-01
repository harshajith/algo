import leetcode.april.ContiguousArray;
import org.junit.Before;
import org.junit.Test;

public class ContiguousArrayTest {

    ContiguousArray contiguousArray;

    @Before
    public void setUp(){
        contiguousArray = new ContiguousArray();
    }

    @Test
    public void contiguousArrayTest(){
        int[] input = new int[]{0,1,1,0,1,1};
        int maxLength = contiguousArray.findMaxLength1(input);
        assert maxLength == 4;
    }

    @Test
    public void contiguousArrayTest1(){
        int[] input = new int[]{0,1};
        int maxLength = contiguousArray.findMaxLength1(input);
        assert maxLength == 2;
    }

    @Test
    public void contiguousArrayTest2(){
        int[] input = new int[]{0,1,0};
        int maxLength = contiguousArray.findMaxLength(input);
        assert maxLength == 2;
    }

    @Test
    public void contiguousArrayTest3(){
        int[] input = new int[]{0};
        int maxLength = contiguousArray.findMaxLength(input);
        assert maxLength == 0;
    }
}
