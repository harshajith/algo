package leetcode0;

import java.util.*;
import java.util.LinkedList;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder2 {

    public static void main(String[] args){
        WordLadder2 ladder2 = new WordLadder2();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> res = ladder2.findLadders("hit", "cog", wordList);
        for(List<String> it: res){
            String response = String.join(", ", it);
            System.out.println(response);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, LinkedList<String>> path = new HashMap<>();

        wordSet.remove(beginWord);
        int level = 0;
        int wordLength = beginWord.length();

        Map<String, Integer> fromPos = new HashMap<>();
        fromPos.put(beginWord, -1);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Map<String, Integer> levels = new HashMap<>();
        levels.put(beginWord, 1);
        Map<String, LinkedList<String>> children = new HashMap<>();
        boolean endFound = false;

        while(!queue.isEmpty() && !endFound){
            ++level;

            int levelItems = queue.size();
            for(int i=0; i<levelItems; i++){
                String origWord = queue.poll();

                char[] ch = origWord.toCharArray();
                for(int pos=0; pos<origWord.length(); pos++){
                    if(fromPos.get(origWord) == pos) continue;
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == origWord.charAt(pos)) continue;
                        ch[pos] = c;
                        String newWord = new String(ch);

                        if(newWord.equals(endWord) || wordSet.contains(newWord)){
                            levels.put(newWord, level+1);
                            if(children.get(origWord) == null){
                                LinkedList<String> list = new LinkedList<>();
                                list.add(newWord);
                                children.put(origWord, list);
                            }else {
                                children.get(origWord).add(newWord);
                            }
                            wordSet.remove(newWord);

                            if(newWord.equals(endWord)){
                                endFound = true;
                            }else {
                                queue.add(newWord);
                                fromPos.put(newWord, pos);
                            }
                        }else {
                            if(levels.keySet().contains(newWord)){
                                if(levels.get(newWord) == level +1) {
                                    children.get(origWord).add(newWord);
                                }
                            }
                        }
                    }
                }
            }
        }

        if(endFound){
            List<String> line = new ArrayList<>();
            line.add(beginWord);
            dfs(endWord, beginWord, line, result, children);
        }

        return result;
    }

    private void dfs(String endWord, String curWord, List<String> line, List<List<String>> res, Map<String, LinkedList<String>> children){

        if(curWord.equals(endWord)){
            res.add(line);
            return;
        }

        LinkedList<String> adj = children.get(curWord);
        for(String it: adj){
            line.add(it);
            dfs(endWord, it, line, res, children);
            line.remove(it);
        }
    }

}
