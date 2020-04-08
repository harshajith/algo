package leetcode;

import java.util.*;
import java.util.LinkedList;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int res = 0;
        while(!queue.isEmpty()){
            for(int k = queue.size(); k>0; --k){
                String word = queue.poll();
                if(word.equals(endWord)){
                    return res+1;
                }
                for(int i=0; i< word.length(); i++){
                    char[] wordChars = word.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ++ch){
                        wordChars[i] = ch;
                        String newWord = new String(wordChars);
                        if(wordSet.contains(newWord) && !newWord.equals(word)){
                            queue.add(newWord);
                        }
                    }
                }
            }
            ++res;
        }
        return 0;
    }

    public static void main(String[] args){
        WordLadder wordLadder= new WordLadder();
        String[] a = new String[]{"hot","dot","dog","lot","log","cog"};
        int ladderLength = wordLadder.ladderLength("hit", "cog", Arrays.asList(a));
        System.out.println(ladderLength);
    }

}
