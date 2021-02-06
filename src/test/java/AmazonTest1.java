import org.junit.Test;

import java.util.Arrays;

public class AmazonTest1 {

    @Test
    public void testUnion(){
        int[] a = new int[]{2, 10, 14, 19, 51, 71};
        int[] b = new int[]{2, 9, 19, 40, 51};

        leetcode.jan.AmazonTest1 amazonTest1 = new leetcode.jan.AmazonTest1();
        int[] result  = amazonTest1.union(a, b);

        System.out.println(Arrays.toString(result));
    }
}
