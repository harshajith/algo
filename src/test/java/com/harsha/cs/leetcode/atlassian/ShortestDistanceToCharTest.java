package com.harsha.cs.leetcode.atlassian;

import leetcode.atlassian.ShortestDistanceToCharacter;
import org.junit.Test;

import java.util.Arrays;

public class ShortestDistanceToCharTest {

    @Test
    public void testShortestDistance(){
        ShortestDistanceToCharacter solution = new ShortestDistanceToCharacter();
        int[] result = solution.shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testShortestDistance1(){
        ShortestDistanceToCharacter solution = new ShortestDistanceToCharacter();
        int[] result = solution.shortestToChar("aaab", 'a');
        System.out.println(Arrays.toString(result));
    }
}
