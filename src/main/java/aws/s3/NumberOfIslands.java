package aws.s3;

import java.util.LinkedList;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {

    boolean[][] visited;
    char[][] grid;
    int R = 0;
    int C = 0;

    int islands = 0;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(visited[i][j] == false){
                    if(grid[i][j] == '1'){
                        traveseForNeighbours(i, j);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    private void traveseForNeighbours(int x, int y){
        LinkedList<Integer> rQueue = new LinkedList<>();
        LinkedList<Integer> cQueue = new LinkedList<>();
        rQueue.add(x);
        cQueue.add(y);
        visited[x][y] = true;

        while(!rQueue.isEmpty()){
            int r = rQueue.poll();
            int c = cQueue.poll();
            checkNeighbours(rQueue, cQueue, r, c);
        }
    }

    private void checkNeighbours(LinkedList<Integer> rQueue, LinkedList<Integer> cQueue, int r, int c){

        int[] rVector = new int[]{-1, 1, 0, 0};
        int[] cVector = new int[]{0, 0, -1, 1};

        for(int i=0; i<rVector.length; i++){
            int rr = r + rVector[i];
            int cc = c + cVector[i];


            if(rr < 0 || cc < 0) continue; // less than grid row columns
            if(rr >= R || cc >= C) continue; // greater than grid row columns
            if(visited[rr][cc] == true) continue; // already visited
            if(grid[rr][cc] == '0') continue; // water

            rQueue.add(rr); // if land we add them to the queue
            cQueue.add(cc);
            visited[rr][cc] = true;
        }
    }

    public static void main(String[] args){

        char[][] grid = new char[6][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';

        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';

        grid[4][0] = '0';
        grid[4][1] = '0';
        grid[4][2] = '1';
        grid[4][3] = '0';
        grid[4][4] = '0';

        grid[5][0] = '0';
        grid[5][1] = '0';
        grid[5][2] = '0';
        grid[5][3] = '1';
        grid[5][4] = '1';

        NumberOfIslands islands = new NumberOfIslands();
        int x = islands.numIslands(grid);
        System.out.println(x);
    }
}
