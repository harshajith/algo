package leetcode.jan;

public class ReverseString {

    public String reverseIteratively(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0; i--){
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    /**
     * Time complexity O(n)
     * Space complexity : O(n)
     * @param input
     * @return
     */
    public String reverseRecursively(String input) {
        if(input.length() < 2) return input;
        return input.substring(input.length()-1) + reverseIteratively(input.substring(0, input.length()-1));
    }
}
