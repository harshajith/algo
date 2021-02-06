import leetcode.jan.NumberOfIslands;
import org.junit.Before;
import org.junit.Test;

public class NumberOfIslandsTest {

    NumberOfIslands numberOfIslands;
    @Before
    public void setup(){
        numberOfIslands = new NumberOfIslands();
    }

    @Test
    public void testNumberOfIslands(){
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        int islands = numberOfIslands.numIslands(grid);
        assert islands == 1;
    }

    @Test
    public void testNumberOfIslands1(){
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        int islands = numberOfIslands.numIslands(grid);
        assert islands == 3;
    }
}
