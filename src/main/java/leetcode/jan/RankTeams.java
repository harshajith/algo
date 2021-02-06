package leetcode.jan;

import java.util.*;

/**
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
 *
 * The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 *
 * Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
 *
 * Return a string of all teams sorted by the ranking system.
 *
 *
 *
 * Example 1:
 *
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
 * Team B was ranked second by 2 voters and was ranked third by 3 voters.
 * Team C was ranked second by 3 voters and was ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team and team B is the third.
 * Example 2:
 *
 * Input: votes = ["WXYZ","XYZW"]
 * Output: "XWYZ"
 * Explanation: X is the winner due to tie-breaking rule. X has same votes as W for the first position but X has one vote as second position while W doesn't have any votes as second position.
 * Example 3:
 *
 * Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * Explanation: Only one voter so his votes are used for the ranking.
 * Example 4:
 *
 * Input: votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
 * Output: "ABC"
 * Explanation:
 * Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
 * Team B was ranked first by 2 voters, second by 2 voters and third by 2 voters.
 * Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
 * There is a tie and we rank teams ascending by their IDs.
 */
public class RankTeams {

    /**
     *
     * A : [4, 2, 0]
     * B : [3, 3, 2]
     * C : [2, 2, 3]
     * @param votes
     * @return
     */
    public String rankTeams1(String[] votes) {
        if(votes == null || votes.length < 1) return "";
        Map<Character, int[]> rankMap = new HashMap<>();
        for(String vote: votes){ // Iterate through each vote "ABC"
            for(int i=0; i<vote.length(); i++){
                char c = vote.charAt(i); // vote char in position i
                int[] positionVotes = rankMap.getOrDefault(c, new int[vote.length()]); // get position votes array for the current Char
                positionVotes[i]++; // increment the position votes
                rankMap.put(c, positionVotes);
            }
        }

        Comparator<Character> comparator = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int[] a = rankMap.get(o1);
                int[] b = rankMap.get(o2);
                for(int i=0; i< a.length; i++){
                    if(a[i] != b[i]){
                        return b[i] - a[i];
                    }
                }
                return 0;
            }
        };

        ArrayList<Character> charArray = new ArrayList<>(rankMap.keySet());
        Collections.sort(charArray, comparator);
        String result = "";
        for(Character c: charArray){
            result += c;
        }
        return result;
    }














    public String rankTeams(String[] votes) {
        Map<Character, int[]> ranks = new HashMap<>(); // Charater and their ranking array.
        for(String vote: votes){
            for(int i=0; i< vote.length(); i++){
                char c = vote.charAt(i);
                int[] charRanks = ranks.getOrDefault(c, new int[vote.length()]);
                charRanks[i]++;
                ranks.put(c, charRanks);
            }
        }

        Comparator<Character> comparator = (o1, o2) -> {
            int[] v1 = ranks.get(o1);
            int[] v2 = ranks.get(o2);
            for(int i=0; i<v1.length; i++){
                if(v1[i] != v2[i]){
                    return v2[i] - v1[i];
                }
            }
            return 0;
        };

        List<Character> charList = new ArrayList<>(ranks.keySet());
        Collections.sort(charList, comparator);

        StringBuilder sb = new StringBuilder();
        for(Character c: charList){
            sb.append(c);
        }

        return sb.toString();
    }
}
