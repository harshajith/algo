package leetcode;

import java.util.LinkedList;


public class GridShortestPathSolver {

    private char[][] grid;
    private int height, width;
    private boolean[][] visited;
    private int count_in_next_layer = 0; // how many to be dequeued before increasing the move_count;
    private int left_in_layer = 1; // how many is added in the queue for a layer
    private int move_count = 0;

    private void createGrid(){
        height = 5;
        width = 5;
        grid = new char[height][width];
        visited = new boolean[height][width];
        grid[1][1] = '#';
        grid[2][2] = '#';
        grid[4][1] = '#';
        grid[3][2] = 'E';
        grid[0][0] = 'S';
    }

    private void visitNeighbours(LinkedList<Integer> rQueue, LinkedList<Integer> cQueue, int r, int c){
        int[] xCords = new int[]{-1, 1, 0, 0};
        int[] yCords = new int[]{0, 0, -1, 1};

        int rr, cc;
        for(int i=0; i<xCords.length; i++){
            rr = r + xCords[i];
            cc = c + yCords[i];

            if(rr<0 || cc<0) continue;
            if(rr > height-1 || cc > width -1) continue; // check for the grid size
            if(grid[rr][cc] == '#') continue;
            if(visited[rr][cc] == true) continue;

            rQueue.add(rr);
            cQueue.add(cc);

            visited[rr][cc] = true;
            count_in_next_layer++;
        }
    }

    private int findShortestPath(){
        int r = 0, c = 0; // starting point
        LinkedList<Integer> rQueue = new LinkedList<>();
        LinkedList<Integer> cQueue = new LinkedList<>();
        rQueue.add(r);
        cQueue.add(c);
        boolean foundTarget = false;
        visited[r][c] = true;

        while(!rQueue.isEmpty()){
            int x = rQueue.poll();
            int y = cQueue.poll();

            if(grid[x][y] == 'E'){
                foundTarget = true;
                break;
            }
            visitNeighbours(rQueue, cQueue, x, y);
            left_in_layer--; // reduce as we deque
            if(left_in_layer == 0){
                left_in_layer = count_in_next_layer;
                count_in_next_layer = 0;
                move_count++;
            }
        }
        if(foundTarget == true){
            return move_count;
        }else {
            return -1;
        }
    }

    public static void main(String[] args){
        GridShortestPathSolver pathSolver = new GridShortestPathSolver();
        pathSolver.createGrid();
        int movesToTarget = pathSolver.findShortestPath();
        System.out.println("Moves to target: :: " + movesToTarget);

    }

}
