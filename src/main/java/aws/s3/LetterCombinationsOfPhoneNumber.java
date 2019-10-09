package aws.s3;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfPhoneNumber {

    public List<String> combinations(String digits){

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 1){
            return result;
        }

        String[] mapping = new String[]{
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"

        };

        findLetterCombinations(result, digits, "", 0, mapping);
        return result;
    }

    private void findLetterCombinations(List<String> result, String digits, String current, int index, String[] mapping) {
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for(int i=0; i<letters.length(); i++){
            findLetterCombinations(result, digits, current + letters.charAt(i), index+1, mapping);
        }
    }

    public static void main(String[] args){
        String input = "233";
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        List<String> res = solution.combinations(input);
        for(String s: res){
            System.out.println(s);
        }
    }

}
