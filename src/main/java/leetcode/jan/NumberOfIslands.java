package leetcode.jan;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * Medium
 *
 * 7493
 *
 * 233
 *
 * Add to List
 *
 * Share
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * Accepted
 * 941,128
 * Submissions
 * 1,929,947
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if(grid == null || grid.length < 1) return 0;
        int counter = 0;
        // O(m * n)
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                char c = grid[i][j];
                if(c == '1' && !visited[i][j]){
                    traverseEntireIsland(i, j, grid, visited);
                    counter ++;
                }
            }
        }
        return counter;
    }

    /**
     * BFS traversing all the adjacent cells.
     * @param i
     * @param j
     * @param visisted
     */
    private void traverseEntireIsland(int i, int j, char[][] grid, boolean[][] visisted) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        int[][] addon = new int[][]{
                {-1,0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        xQueue.add(i);
        yQueue.add(j);


        while(!xQueue.isEmpty()){
            int x = xQueue.poll();
            int y = yQueue.poll();

            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                if(!visisted[x][y] && grid[x][y] == '1'){
                    visisted[x][y] = true;
                    //check boundaries
                    for(int k=0; k<addon.length; k++){
                        xQueue.add(x + addon[k][0]);
                        yQueue.add(y + addon[k][1]);
                    }
                }
            }
        }
    }
}
