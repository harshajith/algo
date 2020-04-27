package leetcode;

import java.util.*;

/**
 * Top K Frequent Words
 * Medium
 *
 * 1473
 *
 * 123
 *
 * Add to List
 *
 * Share
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopFrequentKWords {

    public List<String> topKFrequent(String[] words, int k) {
       List<String> result = new ArrayList<>();

       Comparator<Integer> comparator = new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o2.compareTo(o1);
           }
       };

        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){ // O(n)
            if(map.keySet().contains(word)){
                map.put(word, map.get(word)+1); // O(1)
            }else {
                map.put(word, 1);
            }
        }


        Map<Integer, List<String>> tMap = new TreeMap<>(comparator);

        for(String word: map.keySet()){ // O(n)
            int freq = map.get(word);
            List<String> stList = tMap.getOrDefault(freq, new ArrayList<>());
            stList.add(word);
            tMap.put(freq, stList);
        }

        for(Integer key: tMap.keySet()){
            List<String> strings = tMap.get(key);
            Collections.sort(strings);
            for(String st: strings){
                if(result.size() < k){
                    result.add(st);
                }else {
                    break;
                }
            }
        }

        return result;
    }



}
