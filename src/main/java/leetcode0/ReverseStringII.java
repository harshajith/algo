package leetcode0;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 * Accepted
 * 68,632
 * Submissions
 * 148,318
 */


public class ReverseStringII {

    public static void main(String[] args){
        ReverseStringII sol = new ReverseStringII();
        String s = "abcdefg"; int k = 2;
        String x = sol.reverseStr1(s, k);
        System.out.println(x);
    }


    /**
     * Method 1 =========================================================================
     * @param s
     * @param k
     * @return
     */

    public String reverseStr1(String s, int k) {
        if(s == null || s.isEmpty()) return s;
        char[] ch = s.toCharArray();
        return reverse1(ch, 0, k);
    }

    private String reverse1(char[] ch, int i, int k) {

       while(i < ch.length){
           int lengthToEnd = ch.length - i;
           if(lengthToEnd < k){
               reverseStringInK(ch, i, ch.length-1);
               break;
           }else if(lengthToEnd >= k && lengthToEnd < 2*k){
               reverseStringInK(ch, i, i+k-1);
               break;
           }else {
               reverseStringInK(ch, i, i+k-1);
               i = i+ (2*k);
           }
       }
       return new String(ch);
    }

    private void reverseStringInK(char[] input, int start, int end){
        while(start < end){
            char tmp = input[start];
            input[start++] = input[end];
            input[end--] = tmp;
        }
    }


    /**
     *
     *
     * METHOD 2 =================================================================
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        if(s == null || s.isEmpty()) return s;
        char[] ch = s.toCharArray();
        return reverse(ch, 0, k);
    }

    public String reverse(char[] ch, int index, int k){
        int length = ch.length - index;
        if(length < k){
            rev(ch, length, index);
            return new String(ch);
        }else if(length < 2*k && length >= k){
            rev(ch, k, index);
            return new String(ch);
        }else {
            rev(ch, k, index);
            return reverse(ch, index+2*k, k);
        }
    }

    public void rev(char[] ch, int N, int index){
        int i=index; int j=index+N-1;
        while(i<j){
            char tmp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = tmp;
        }
    }
}