package leetcodeApril;

import java.util.LinkedList;

/**
 * Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {



    public int maximalSquareDynamicProgrammingModel(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] DP = new int[r][c];

        for(int i=0; i<r; i++){
            if(i > 0){
                DP[i][0] = Math.max(DP[i-1][0], Character.getNumericValue(matrix[i][0]));
            }else {
                if(matrix[i][0] != '0') {
                    DP[i][0] = 1;
                }
            }
        }

        for(int j=0; j<c; j++){
            if(matrix[0][j] != '1'){
                DP[0][j] = 1;
            }
        }

        int height = 0;
        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                if(matrix[i][j] == '1'){
                    DP[i][j] = 1 + Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i][j-1]));
                    height = Math.max(height, DP[i][j]);
                }
            }
        }
        return height * height;
    }


    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0) return 0;
        int Rows = matrix.length;
        int Columns = matrix[0].length;

        int result = 0;
        char one = '1';

        for(int i = 0; i< Rows; i++){
            for(int j=0; j<Columns; j++){
                if(matrix[i][j] == one){
                    int square = checkSquare(matrix, i, j, Rows, Columns);
                    result = Math.max(result, square);
                }
            }
        }
        return result;
    }


    public int checkSquare(char[][] matrix, int x, int y, int R, int C){

        int[] xVector = new int[]{1,1,0};
        int[] yVector = new int[]{0,1,1};

        int rowIndex = x;
        int lineLength = 1;
        char zero = '0';

        boolean[][] visited = new boolean[R][C];
        LinkedList<Integer> xQueue = new LinkedList<>();
        LinkedList<Integer> yQueue = new LinkedList<>();
        xQueue.add(x);
        yQueue.add(y);
        visited[x][y] = true;

        while(!xQueue.isEmpty()){
            int a = xQueue.poll();
            int b = yQueue.poll();
            for(int i=0; i<xVector.length; i++){
                int xx = a + xVector[i];
                int yy = b + yVector[i];

                if(xx >= R || yy >= C)  return lineLength * lineLength;
                if(visited[xx][yy]) continue;

                if(matrix[xx][yy] == zero){
                    return lineLength * lineLength;
                }else {
                    xQueue.add(xx);
                    yQueue.add(yy);
                    visited[xx][yy] = true;
                    if(i == xVector.length -1 && xx == rowIndex) lineLength++;
                }
            }
        }
        return lineLength * lineLength;
    }
}
