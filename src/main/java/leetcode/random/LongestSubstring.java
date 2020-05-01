package leetcode.random;

import java.util.Stack;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 */
public class LongestSubstring {

    private Stack<Character> stack = new Stack<>();



    public int lengthOfLongestSubstring(String s) {

        if(s.length() < 1) return 0;
        int length = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty()){
                char previous = stack.pop();
                if(c == previous){
                    stack = new Stack<>(); // empty stack.
                    stack.push(c);
                }else {
                    stack.push(previous);
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
            if(length < stack.size()){
                length = stack.size();
            }
        }

        return length;
    }


    public static void main(String[] input){
        LongestSubstring longestSubstring = new LongestSubstring();
        int length = longestSubstring.lengthOfLongestSubstring(
                "abcabcbb");
        System.out.println(length);

    }

}
