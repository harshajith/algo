package leetcode.may;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        return nums[mid];

    }

    public static void main(String[] args){
        int[] a = new int[]{2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(a));

    }
}
