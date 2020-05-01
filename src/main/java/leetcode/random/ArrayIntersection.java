package leetcode.random;


import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 */
public class ArrayIntersection {

    public static void main(String[] args){

        int[] a = new int[]{4,9,5};
        int[] b = new int[]{9,4,9,8,4};

        ArrayIntersection solution = new ArrayIntersection();
        int[] result = solution.intersection(a, b);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        int l1= nums1.length;
        int l2 = nums2.length;

        int count = 0;
        int[] result = new int[Math.min(l1, l2)];
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for(int i=0; i< l2; i++){
            set2.add(nums2[i]);
        }

        for(int i=0; i<l1; i++){
            if(set2.contains(nums1[i])){
                resultSet.add(nums1[i]);
            }
        }


        int[] finalResult = new int[resultSet.size()];
        int c = 0;
        for(Integer x: resultSet){
            finalResult[c++] = x;
        }
        return finalResult;
    }

}
