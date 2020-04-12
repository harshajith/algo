import leetcode30Challenge.LastStoneWeight;
import org.junit.Test;

public class LastStoneWeightTest {

    @Test
    public void testLastStoneWeight(){
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] input = new int[]{2,7,4,1,8,1};
        assert lastStoneWeight.lastStoneWeight(input) == 1;

    }

}
