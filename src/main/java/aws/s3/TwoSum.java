package aws.s3;

import java.util.HashSet;
import java.util.Set;

/**
 * Find all pairs which contain sum a+b = 4
 */
public class TwoSum {

    public static void solution(int[] input, int sum){

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<input.length; i++){
            int current = input[i];
            if(set.contains(sum-current)){
                System.out.println("[ " + (sum-current) + "," + current + " ]");
            }else {
                set.add(current);
            }
        }


    }

    public static void main(String[] args){
        int[] actual = { 5, 1, 6, 2, 3, 4, 2};
        TwoSum.solution(actual, 4);
    }

}
