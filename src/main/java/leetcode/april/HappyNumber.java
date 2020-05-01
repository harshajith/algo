package leetcode.april;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public void printInSequence(int n){

        int current = n;
        while(current != 0){
            System.out.println(current % 10);
            current = current / 10;
        }
    }


    /**
     * if n = 1234345, mod 10 gives the last number and remainder is rest of the numbers.
     * @param n
     * @return
     */
    public boolean isHappy(int n){
        HashSet<Integer> seenSet = new HashSet<>();
        while(n != 1){
            int current = n;
            int sum = 0;
            while(current != 0){
                sum += (current % 10) * (current % 10);
                current = current / 10;
            }
            if(seenSet.contains(sum)){
                return false;
            }

            seenSet.add(sum);
            n = sum;
        }
        return true;
    }


    public static void main(String[] args){
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(32));
    }
}
