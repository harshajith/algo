package com.harsha.cs.leetcode.feb;


import leetcode.feb.ShortestPathInBinaryMatrix;
import org.junit.Test;

/**
 *
 */
public class ShortestpathBinaryMatrixTest {

    @Test
    public void testShortestPath(){
        ShortestPathInBinaryMatrix sol = new ShortestPathInBinaryMatrix();

        int[][] grid = new int[][]{
                {0,1},
                {1,0}
        };
        assert 2 == sol.shortestPathBinaryMatrixOptimized(grid);
    }

    @Test
    public void testShortestPath1(){
        ShortestPathInBinaryMatrix sol = new ShortestPathInBinaryMatrix();

        int[][] grid = new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        assert 4 == sol.shortestPathBinaryMatrixOptimized(grid);
    }

    @Test
    public void testShortestPath2(){
        ShortestPathInBinaryMatrix sol = new ShortestPathInBinaryMatrix();

        int[][] grid = new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,1}
        };
        assert -1 == sol.shortestPathBinaryMatrixOptimized(grid);
    }
}
