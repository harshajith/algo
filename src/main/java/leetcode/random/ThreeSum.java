package leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * a+b+c = 4
 * O(n2)
 */
public class ThreeSum {

    private static void solution(int[] input, int total){

        Arrays.sort(input);
        ArrayList<List<Integer>> result = new ArrayList<>();

        for(int i=0; i< input.length-1; i++){
            int j = i+1;
            int k = input.length-1;

            if(i > 0 && input[i] == input[i-1]){ // same value present
                continue;
            }

            while(j<k){

                if(k < input.length -1 && input[k] == input[k+1]){
                    k--;
                    continue;
                }

                int sum = input[i] + input[j] + input[k];
                int diff = sum - total;

                if(diff == 0){
                    System.out.println("[ " + input[i] + "," + input[j] + "," + input[k] + " ]");
                    j++;
                    k--;
                    List<Integer> list = new ArrayList<>();
                    list.add(input[i]);
                    list.add(input[j]);
                    list.add(input[k]);
                    result.add(list);
                } else if(diff < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
    }


    public static void main(String[] args){
        int[] actual = { 5, 1, 6, 2, 3, 4, 2};
        ThreeSum.solution(actual, 10);
    }

}
