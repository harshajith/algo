package com.harsha.cs.leetcode;

import leetcode.feb.LongestHarmoniousSubsequence;
import org.junit.Test;

public class LongestHarmoniousSubsequenceTest {

    @Test
    public void testLongestSubsequence() {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        assert 5 == longestHarmoniousSubsequence.findLHS(nums);
    }

    @Test
    public void testLongestSubsequence1() {
        int[] nums = new int[]{1,1,1,1};
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        assert 0 == longestHarmoniousSubsequence.findLHS(nums);
    }

    /**
     * Values contains increase and decreasing order
     */
    @Test
    public void testLongestSubsequence2() {
        int[] nums = new int[]{1,2,1,3,0,0,2,2,1,3,3};
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        assert 6 == longestHarmoniousSubsequence.findLHS(nums);
    }
}
