package aws.s3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for(int i=0; i<strs.length; i++){
            String key = strs[i];
            updateAnagramsMap(strs[i]);
        }

        for(String key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    private void updateAnagramsMap( String input){
        if(!map.isEmpty()){
            boolean foundAnagram = false;
            for(String str: map.keySet()){
                if(isAnagram(str, input)){
                    map.get(str).add(input);
                    foundAnagram = true;
                }
            }
            if(foundAnagram == false){
                List<String> anagrams = new ArrayList<>();
                anagrams.add(input);
                map.put(input, anagrams);
            }
        }else {
            List<String> anagrams = new ArrayList<>();
            anagrams.add(input);
            map.put(input, anagrams);
        }
    }

    private boolean isAnagram(String key, String input){
        if(key.length() != input.length()) return false;
        char[] chars = key.toCharArray();

        for(int i=0; i<chars.length; i++){
            if(input.indexOf(String.valueOf(chars[i])) == -1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams anagrams = new GroupAnagrams();
        List<List<String>> res = anagrams.groupAnagrams(input);
        System.out.println(res.toString());
    }

}
