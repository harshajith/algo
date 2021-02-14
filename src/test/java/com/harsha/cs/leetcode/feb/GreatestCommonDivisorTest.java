package com.harsha.cs.leetcode.feb;

import leetcode.atlassian.GreatestCommonDivisorOfStrings;
import org.junit.Test;

public class GreatestCommonDivisorTest {

    @Test
    public void testGreatestCommonDivisor(){
        GreatestCommonDivisorOfStrings sol = new GreatestCommonDivisorOfStrings();
        assert "ABC".equals(sol.gcdOfStrings("ABCABC", "ABC"));
    }

    @Test
    public void testGreatestCommonDivisor1(){
        GreatestCommonDivisorOfStrings sol = new GreatestCommonDivisorOfStrings();
        assert "AB".equals(sol.gcdOfStrings("ABABAB", "ABAB"));
    }

    @Test
    public void testGreatestCommonDivisor2(){
        GreatestCommonDivisorOfStrings sol = new GreatestCommonDivisorOfStrings();
        assert "".equals(sol.gcdOfStrings("LEET", "CODE"));
    }

    @Test
    public void testGreatestCommonDivisor3(){
        GreatestCommonDivisorOfStrings sol = new GreatestCommonDivisorOfStrings();
        assert "".equals(sol.gcdOfStrings("ABDEF", "ABC"));
    }
}
