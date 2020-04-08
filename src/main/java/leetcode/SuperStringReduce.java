package leetcode;

import java.util.Stack;

public class SuperStringReduce {

    /**
     * Input = aaabccddd
     * @param input
     */
    public void reduceString(char[] input){

        if(input.length == 0){
            System.out.println("Empty");
            return;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0; i < input.length; i++){
            if(!stack.isEmpty()){
                char previous = stack.pop();
                char current = input[i];

                if(previous == current)  continue;

                stack.push(previous);
                stack.push(current);
            }else {
                stack.push(input[i]);
            }
        }

        if(stack.isEmpty()){
            System.out.println("Empty");
        }else {
            System.out.println(stack.toString());
        }

    }

    public static void main(String[] args){
        String input = "aaaaaa";
        char[] array = new char[input.length()];
        array = input.toCharArray();

        SuperStringReduce reduce = new SuperStringReduce();
        reduce.reduceString(array);
    }
}
