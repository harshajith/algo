package leetcode.feb;


/**
 * 1071. Greatest Common Divisor of Strings
 * Easy
 *
 * 704
 *
 * 166
 *
 * Add to List
 *
 * Share
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * Example 4:
 *
 * Input: str1 = "ABCDEF", str2 = "ABC"
 * Output: ""
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() > str2.length()){
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        String gcd = "";
        for(int i=0; i<str1.length(); i++){
            String a = str1.substring(0, i+1);
            String c = str2.substring(0, i+1);

            if(!a.equals(c)) continue;
            // check if the pattern present in both strings
            if(str1.length() % a.length() > 0  || str2.length() % a.length() > 0) continue;
            boolean flag = false;

            for(int k=i+1; k<=str1.length()-a.length(); k+=a.length()){
                String b = str1.substring(k, k+a.length());
                if(!a.equals(b)) {
                    flag = true;
                    break;
                }
            }

            if(flag) continue;
            flag = false;

            for(int k=i+1; k<=str2.length()-a.length(); k+=a.length()){
                String b = str2.substring(k, k+a.length());
                if(!a.equals(b)) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            gcd = a;
        }
        return gcd;
    }
}
