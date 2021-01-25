package leetcode.jan;


import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length < 1){
            return 0;
        }
        mergeSort(nums, nums.length);
        return nums[nums.length - k];
    }

    /**
     * sorting the array using mergeSort,
     * @param nums
     * @param n : length of the array
     * @return
     */
    public void mergeSort(int[] nums, int n){
        if(n < 2) return;

        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for(int i=0; i<mid; i++){
            left[i] = nums[i];
        }
        for(int i=mid; i<n; i++){
            right[i-mid] = nums[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n-mid);

        merge(nums, left, right, mid, n-mid);
    }

    private void merge(int[] nums, int[] left, int[] right, int l, int r) {
        int k = 0, i=0, j=0;
        while(i < l && j < r){
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }
        while(i < l){
            nums[k++] = left[i++];
        }

        while(j < r){
            nums[k++] = right[j++];
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,6,4};
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(nums, 2));
    }


}
