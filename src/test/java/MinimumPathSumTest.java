import leetcode30Challenge.MinimumPathSum;
import org.junit.Before;
import org.junit.Test;

public class MinimumPathSumTest {

    MinimumPathSum minimumPathSum;

    @Before
    public void setUp(){
        minimumPathSum = new MinimumPathSum();
    }

    @Test
    public void testMinimumPathSum(){
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };

        int result = minimumPathSum.minPathSum(grid);
        assert result == 7;

    }
}
