package leetcode.feb;



import java.util.*;

/**
 * Shortest Path in Binary Matrix
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 *
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 *
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,0]]
 *
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 *
 *
 * Output: 4
 *
 *
 *
 * Note:
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 *    Hide Hint #1
 * Do a breadth first search to find the shortest path.
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrixOptimized(int[][] grid) {
        int L = grid.length;
        int R = grid[0].length;


        if(grid[0][0] == 1 || grid[L-1][R-1] == 1) return -1; // no path exist
        boolean[][] visited = new boolean[L][R];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        grid[0][0] = 1;
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            int distance = grid[x][y];
            if(x == L-1 && y == R-1) {
                return grid[x][y]; // return distance of the last element of the grid.
            }

            for(int[] neighbour: getNeighbours(x, y, grid, visited)){
                int xx = neighbour[0];
                int yy = neighbour[1];
                grid[xx][yy] = distance + 1;
                queue.add(new int[]{xx, yy});
            }
        }
        return -1;
    }

    private List<int[]> getNeighbours(int x, int y, int[][] grid, boolean[][] visited){
        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}}; // moving directions

        List<int[]> neighbours = new ArrayList<>();

        for(int i=0; i<directions.length; i++){
            int xx = x + directions[i][0];
            int yy = y + directions[i][1];

            if(xx < 0 || yy < 0 || xx >= grid.length || yy >= grid[0].length || grid[xx][yy] == 1 || visited[xx][yy]) continue;
            neighbours.add(new int[]{xx, yy});
            visited[xx][yy] = true;
        }
        return neighbours;
    }

    public int shortestPathBinaryMatrixMethod2(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int L = grid.length;
        int R = grid[0].length;
        int[][] dp = new int[L][R];

        // update DP array to max;
        for(int x=0; x<L; x++) {
            for (int y = 0; y < R; y++) {
                dp[x][y] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 1;

        int[] xx = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] yy = new int[]{-1,0,1,-1,1,-1,0,1};

        for(int x=0; x<grid.length; x++){
            for(int y=0; y<grid[0].length; y++){

                if(grid[x][y] == 1) continue;

                for(int k=0; k<xx.length; k++){
                    int x1 = x + xx[k];
                    int y1 = y + yy[k];

                    if(x1 < 0 || y1 < 0) continue;
                    if(x1 > grid.length-1 || y1 > grid[0].length-1) continue;
                    if(grid[x1][y1] == 1) continue;

                    dp[x][y] = Math.min(dp[x][y], dp[x1][y1] +1);
                }
            }
        }

        if(dp[L-1][R-1] == Integer.MAX_VALUE) return -1;

        return dp[L-1][R-1];
    }

    public int shortestPathBinaryMatrixMethod3(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.add(0); // add first coordinate to the queue.
        yQueue.add(0);
        visited[0][0] = true;
        // add dummy to track the steps.
        xQueue.add(-1); //
        yQueue.add(-1);

        int steps = -1;


        int[] xx = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] yy = new int[]{-1,0,1,-1,1,-1,0,1};

        while(!xQueue.isEmpty()){
            int x = xQueue.poll();
            int y = yQueue.poll();

            if(x == grid.length-1 && y == grid[0].length-1) {
                if(steps == -1) steps = 0;
                steps++;
                break;
            }

            if(x == -1){ // finished one level
                if(steps == -1) steps = 0;
                steps++;
                xQueue.add(-1);
                yQueue.add(-1);
            }else {
                // add possible neighbours
                for(int i=0; i<xx.length; i++){
                    int x1 = x + xx[i];
                    int y1 = y + yy[i];

                    if(x1 < 0 || y1 < 0) continue;
                    if(x1 > grid.length-1 || y1 > grid[0].length-1) continue;
                    if(grid[x1][y1] == 1 || visited[x1][y1]) continue;

                    xQueue.add(x1);
                    yQueue.add(y1);
                    visited[x1][y1] = true;
                }

            }
        }
        return steps;
    }

}
