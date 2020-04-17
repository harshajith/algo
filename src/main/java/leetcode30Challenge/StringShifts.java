package leetcode30Challenge;

/**
 * Perform String Shifts
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 */
public class StringShifts {

    public String stringShift(String s, int[][] shift) {

        if(shift.length < 1 || shift.length > 100) throw new RuntimeException();
        // Calculate the delta of right and left shifts
        int totalLeftShifts = 0;
        int totalRightShifts = 0;
        for(int i=0; i<shift.length; i++){
            int firstDigit = shift[i][0]; // Assumptin: length of internal array is always two as it denote shift and count.
            int secondDigit = shift[i][1];

            if(firstDigit == 1){ // right shift
                totalRightShifts += secondDigit;
            }else { // if it is zero,  left shift
                totalLeftShifts += secondDigit;
            }
        }
        if(totalLeftShifts == totalRightShifts){
            return s;  // no difference
        }else if(totalLeftShifts > totalRightShifts){
            int diff = totalLeftShifts - totalRightShifts;
            int t = diff % s.length(); // if total shifts is more than the length, it negates the whole changes. hence we can see what is remaining
            return s.substring(t) + s.substring(0, t);
        }else {
            int diff = totalRightShifts - totalLeftShifts;
            int t = diff % s.length();
            return s.substring(s.length()-t) + s.substring(0, s.length()-t);
        }
    }

}
