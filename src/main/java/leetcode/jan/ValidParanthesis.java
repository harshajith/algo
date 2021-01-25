package leetcode.jan;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Easy
 *
 * 6538
 *
 * 268
 *
 * Add to List
 *
 * Share
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParanthesis {

    public static void main(String[] args){
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("([)]"));
    }

    public boolean isValid(String s) {
        char[] a = s.toCharArray();
        Stack<String> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        for(char c: a){

            String input = String.valueOf(c);
            if(map.values().contains(input)){
                stack.push(input);
            }else if(stack.isEmpty() && map.keySet().contains(input)) {
                return false;
            }else if(map.keySet().contains(input)){
                String currentValInStack = stack.pop();
                String expectedOne = map.get(input);
                if(!currentValInStack.equals(expectedOne)) return false;
            }
        }

        return stack.isEmpty();
    }
}
