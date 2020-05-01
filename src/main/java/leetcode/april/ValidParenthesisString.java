package leetcode.april;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '('){
                stack1.push(i);
            }else if(chars[i] == '*') {
                stack2.push(i);
            }else {
                if(!stack1.isEmpty()) {
                    stack1.pop();
                }else if(!stack2.isEmpty()) {
                    stack2.pop();
                }else {
                    return false;
                }
            }
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek() < stack2.peek()){
                stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return stack1.isEmpty();
    }

}
