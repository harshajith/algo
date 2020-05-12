package leetcode.may;

import java.util.*;

/**
 * Find the Town Judge
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class FindTownJudge {

    public int findJudge(int N, int[][] trust) {
        Set<Integer> people = new HashSet<>();
        Map<Integer, List<Integer>> judgeToPeople = new HashMap<>();
        for(int[] a: trust){
            people.add(a[0]);
        }

        for(int[] a: trust){
            if(!people.contains(a[1])){
                List<Integer> pList = judgeToPeople.getOrDefault(a[1], new ArrayList<Integer>());
                pList.add(a[0]);
                judgeToPeople.put(a[1], pList);
            }
        }
        List<Integer> p = judgeToPeople.entrySet().iterator().next().getValue(); // number of people mapped to the judge
        if(judgeToPeople.size() > 1) return -1; // multiple judges
        if(p.size() != N-1) return -1;

        return judgeToPeople.entrySet().iterator().next().getKey();
    }


    /**
     * Shorter method
     * @param N
     * @param trust
     * @return
     */
    public int findJudge1(int N, int[][] trust) {

        int[] count = new int[N+1];
        int[] count1 = new int[N+1];

        for(int[] row: trust){
            count[row[0]]--;
            count1[row[1]]++;
        }

        for(int i=1; i<=N;i++){
            if(count[i] == 0 && count1[i] == N-1) return i;
        }
        return -1;
    }

}
