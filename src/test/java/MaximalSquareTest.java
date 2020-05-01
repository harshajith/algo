import leetcodeApril.MaximalSquare;
import org.junit.Test;

public class MaximalSquareTest {

    MaximalSquare maximalSquare = new MaximalSquare();

    @Test
    public void test1(){
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int result = maximalSquare.maximalSquare(matrix);
        assert result == 4;
    }

    @Test
    public void test2(){
        char[][] matrix = new char[][]{
                {'1', '1'}
        };
        int result = maximalSquare.maximalSquare(matrix);
        assert result == 1;
    }

    @Test
    public void test3(){
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int result = maximalSquare.maximalSquareDynamicProgrammingModel(matrix);
        assert result == 4;
    }

    @Test
    public void test5(){
        char[][] matrix = new char[][]{
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0'},
        };
        int result = maximalSquare.maximalSquareDynamicProgrammingModel(matrix);
        assert result == 1;
    }

//    @Test
//    public void test6(){
//        char[][] matrix = new char[][]{
//                {'0', '0', '0', '1'},
//                {'1', '1', '0', '1'},
//                {'1', '1', '1', '1'},
//                {'0', '1', '1', '1'},
//                {'0', '1', '1', '1'}
//        };
//        int result = maximalSquare.maximalSquareDynamicProgrammingModel(matrix);
//        assert result == 9;
//    }
//
//
//    @Test
//    public void test4(){
//        char[][] matrix = new char[][]{
//                {'1', '1'}
//        };
//        int result = maximalSquare.maximalSquareDynamicProgrammingModel(matrix);
//        assert result == 1;
//    }
}
