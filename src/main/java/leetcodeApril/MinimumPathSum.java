package leetcodeApril;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class MinimumPathSum {

    /**
     * find all the paths to end and sort by sum.
     * @param grid
     * @return
     */

    public int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        result[0][0] = grid[0][0];
        int R = grid.length -1;
        int C = grid[0].length -1;

        for(int i=1; i<grid.length; i++){
            result[i][0] = result[i-1][0] + grid[i][0];
        }
        for(int i=1; i<grid[0].length; i++){
            result[0][i] = result[0][i-1] + grid[0][i];
        }

        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[i].length; j++){
                if(result[i-1][j] > result[i][j-1]){
                    result[i][j] = result[i][j-1] + grid[i][j];
                }else {
                    result[i][j] = result[i-1][j] + grid[i][j];
                }
            }
        }
        return result[R][C];
    }

    /**
     * Queue and BFS method
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if(grid.length < 1) return 0;

        int R = grid.length-1;
        int C = grid[0].length-1;

        List<List<Integer>> paths = new ArrayList<>();

        List<Integer> start = new ArrayList<>();
        start.add(grid[0][0]);

        LinkedList<Integer> xQueue = new LinkedList<>();
        LinkedList<Integer> yQueue = new LinkedList<>();

        xQueue.add(0);
        yQueue.add(0);

        LinkedList<List<Integer>> pathQueue = new LinkedList<>();
        pathQueue.add(start);

        int[] xVector = new int[]{0,1}; // can only move down and right
        int[] yVector = new int[]{1,0};

        while(!xQueue.isEmpty()){
            List<Integer> path = pathQueue.poll();

            int x = xQueue.poll();
            int y = yQueue.poll();

            if(x == R && y == C){ // reached the end
                paths.add(path);
            }else {
                // get next possible movements
                for(int i=0; i<xVector.length; i++){
                    int xx = x + xVector[i];
                    int yy = y + yVector[i];

                    if(xx > R || yy > C) continue; // off the grid

                    xQueue.add(xx);
                    yQueue.add(yy);
                    // new path
                    List<Integer> newPath = new ArrayList<>();
                    newPath.addAll(path);
                    newPath.add(grid[xx][yy]);
                    pathQueue.add(newPath);
                }
            }
        }
        List<Integer> pathCosts = paths.stream().map(path -> path.stream().reduce(0, Integer::sum)).collect(Collectors.toList());
        Collections.sort(pathCosts);

        return pathCosts.get(0);

    }
}
