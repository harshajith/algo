package leetcode.feb;

import java.util.ArrayList;
import java.util.List;

/**
 * 415. Add Strings
 * Easy
 *
 * 1523
 *
 * 360
 *
 * Add to List
 *
 * Share
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Accepted
 * 259,624
 * Submissions
 * 538,967
 */
public class AddStrings {

    public static void main(String[] args){
        AddStrings addStrings = new AddStrings();
        String result = addStrings.addStrings("9", "99776");
        System.out.println(result);
    }

    public String addStrings(String num1, String num2) {
        if(num1 == null && num2 == null) return "";

        if(num1 == null && num2 != null) return num2;
        if(num1 != null && num2 == null) return num1;

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int remain = 0, i=c1.length-1, j=c2.length-1;
        List<String> result = new ArrayList<>();

        while(i>=0 && j>=0){
            int n1 = c1[i] - '0';
            int n2 = c2[j] - '0';
            int sum = n1 + n2 + remain;
            remain = sum / 10;
            int val = sum % 10;
            result.add("" + val);
            i--;
            j--;
        }
        while(i >= 0){
            int sum = remain + (c1[i] -  '0');
            remain = sum / 10;
            int val = sum % 10;
            result.add("" + val);
            i--;
        }
        while(j >= 0){
            int sum = remain + (c2[j] -  '0');
            remain = sum / 10;
            int val = sum % 10;
            result.add("" + val);
            j--;
        }
        if(remain == 1) result.add("1");
        StringBuilder sb = new StringBuilder();
        for(int k=result.size()-1; k >= 0; k--){
            sb.append(result.get(k));
        }
        return sb.toString();
    }
}
