package com.harsha.cs.leetcode.atlassian;

import leetcode.atlassian.LemonadeChange;
import org.junit.Before;
import org.junit.Test;

public class LemonadeChangeTest {

    LemonadeChange lemonadeChange;
    @Before
    public void setup(){
        lemonadeChange = new LemonadeChange();
    }

    @Test
    public void testChange1(){
        int[] bills = new int[]{5,5,5,10,20};
        boolean result = lemonadeChange.lemonadeChange(bills);
        assert result == true;
    }

    @Test
    public void testChange2(){
        int[] bills = new int[]{5,5,10,10,20};
        boolean result = lemonadeChange.lemonadeChange(bills);
        assert result == false;
    }

    @Test
    public void testChange3(){
        int[] bills = new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        boolean result = lemonadeChange.lemonadeChange(bills);
        assert result == true;
    }
}
