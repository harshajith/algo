package aws.s3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 419. Battleships in a Board
 * Medium
 *
 * 493
 *
 * 375
 *
 * Favorite
 *
 * Share
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 *
 * Accepted
 */
public class BattleShip {

    int M;
    int N;

    public static void main(String[] args){
        char[][] board = new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        BattleShip battleShip = new BattleShip();
        System.out.println(battleShip.countBattleships(board));
    }


    public int countBattleships(char[][] board) {

        int count = 0;
        M = board.length;
        N = board[0].length;
        boolean[][] visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && visited[i][j] == false){
                    markVisitedCells(visited, board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void markVisitedCells(boolean[][] visited, char[][] board, int i, int j){
        int x = i;
        while(i< M){
            if(board[i][j] == 'X'){
                if(visited[i][j] == false){
                    visited[i][j] = true;
                }else {
                    throw new RuntimeException();
                }
            }
            i++;
        }

        i = x;

        while(j < N){
            if(board[i][j] == 'X'){
                if(visited[i][j] == false){
                    visited[i][j] = true;
                }else {
                    throw new RuntimeException();
                }
            }
            j++;
        }
    }
}
