package com.harsha.cs;

import com.harsha.cs.treechallenge.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Grid {


    int[][] graph;
    static int numberOfRows = 2;
    static int numberOfColumns = 3;

    public static void main(String[] args){
        List<List<Integer>> lot = new ArrayList<>();
        lot.add(Arrays.asList(0,0));
        lot.add(Arrays.asList(0,1));
        lot.add(Arrays.asList(1,1));
        lot.add(Arrays.asList(1,2));

        removeObstacle(2, 3, lot);


    }

    /**
     *
     * @param numRows
     * @param numColumns
     * @param lot
     * @return
     */
    public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot){

        int[][] graph = new int[numRows][numColumns];
        for(List<Integer> location: lot){
            int x = location.get(0);
            int y = location.get(1);
            graph[x][y] = 1;
        }

        graph[1][1] = 9; // goal

        int limit = 1000;

        boolean[][] visited = new boolean[numRows][numColumns];

        bfs(graph, 0,0, visited);

        return 1;
    }

    /**
     * TODO: consider number of columns and rows.
     * @param graph
     * @param x
     * @param y
     * @param visited
     */
    public static void bfs(int[][] graph, int x, int y, boolean[][] visited){

        LinkedList<List<Integer>> queue = new LinkedList<List<Integer>>();
        visited[x][y] = true;
        queue.add(Arrays.asList(x,y));

        int numberInNextlayer = 0;
        int numberLeftInLayer = 1;
        int moves = 0;

        while(!queue.isEmpty()){
            List<Integer> current = queue.poll();
            System.out.println(Arrays.toString(current.toArray()));
            int currentX = current.get(0);
            int currentY = current.get(1);

            if(graph[currentX][currentY] == 9){
                System.out.println("number of moves: " + moves);
                break;
            }

            visited[currentX][currentY] = true;

            checkNextPossibleMoves(currentX, currentY, graph, queue, numberInNextlayer, visited);
            numberLeftInLayer --;
            if(numberLeftInLayer == 0){
                numberLeftInLayer = numberInNextlayer;
                numberInNextlayer --;
                moves++;

            }
        }

    }

    /**
     *
     * @param x
     * @param y
     * @param graph
     * @param queue
     * @param numberInNextLayer
     */
    static void checkNextPossibleMoves(int x, int y, int[][] graph, LinkedList<List<Integer>> queue, int numberInNextLayer, boolean[][] visited){
        int[] xVector = {-1, 1, 0, 0};
        int[] yVector = {0, 0, -1, 1};

        for(int i=0;i<4;i++){
            int xx = x+xVector[i];
            int yy = y+yVector[i];

            if(xx < 0 || yy < 0 || xx >= numberOfRows || yy >= numberOfColumns){
                continue;
            }
            if(graph[xx][yy] == 1){
                if(visited[xx][yy] == false){
                    queue.add(Arrays.asList(xx, yy));
                    visited[xx][yy] = true;
                    numberInNextLayer++;
                }
            }

        }
    }

    static private boolean checkIfValid(List<Integer> move, int[][] graph) {
        int x = move.get(0);
        int y = move.get(1);
        if(graph[x][y] == 1){
            return true;
        }else {
            return false;
        }
    }
}
