package leetcode30Challenge;

/**
 * Backspace String Compare
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {

        if(S.length()<1 || S.length() > 200) throw new RuntimeException();
        if(T.length()<1 || T.length() > 200) throw new RuntimeException();

        while(S.indexOf('#') != -1) {
            int i = S.indexOf('#');
            if (i <= 1) { // first character
                S = S.substring(i + 1);
            } else if (i == S.length() - 1) { // last character
                S = S.substring(0, S.length() - 1);
            } else {
                S = S.substring(0, i-1) + S.substring(i + 1);
            }
        }

        while(T.indexOf('#') != -1) {
            int i = T.indexOf('#');
            if (i <= 1) { // first character
                T = T.substring(i + 1);
            } else if (i == T.length() - 1) { // last character
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, i-1) + T.substring(i + 1);
            }
        }


        return S.equals(T);
    }

    public static void main(String[] args){
        String a = "bxj##tw";
        String b = "bxo#j##tw";
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare(a, b));
    }

}
