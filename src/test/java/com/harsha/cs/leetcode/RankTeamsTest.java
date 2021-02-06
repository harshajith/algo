package com.harsha.cs.leetcode;

import leetcode.jan.RankTeams;
import org.junit.Test;

public class RankTeamsTest {

    @Test
    public void testRankTeams(){
        RankTeams rankTeams = new RankTeams();
        String result = rankTeams.rankTeams(new String[]{"ABC", "ACB", "ABC", "CAB"});
        System.out.println(result);
    }

}
