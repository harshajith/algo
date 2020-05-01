package leetcode.random;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {

    Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> sortedMap = new HashMap<>();

        for(String currentStr: strs){
            char[] chars = currentStr.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!sortedMap.containsKey(sortedStr)){
                sortedMap.put(sortedStr, new ArrayList<>());
            }
            sortedMap.get(sortedStr).add(currentStr);
        }
        result.addAll(sortedMap.values());
        return result;

    }

    public static void main(String[] args){
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams anagrams = new GroupAnagrams();
        List<List<String>> res = anagrams.groupAnagrams(input);
        System.out.println(res.toString());
    }

}
