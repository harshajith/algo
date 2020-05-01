import leetcode.random.SubArraySumEqualsK;
import org.junit.Test;

public class SubArraySumEqualsKTest {

    SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();

    @Test
    public void test1(){
        int[] a = new int[]{1,1,1};
        int result = subArraySumEqualsK.subarraySum(a, 2);
        assert result == 2;
    }

}
