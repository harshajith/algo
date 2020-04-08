package leetcode0;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * =====
 * Notes:
 */
public class MedianOfTwoArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;
        int[] result = new int[totalLength];

        mergeArrays(result, nums1, nums2, nums1.length, nums2.length);

        double median = 0;

        int remain = totalLength%2;
        if(remain == 0){ // event length
            int mid = totalLength/2;
            median = (result[mid-1] + result[mid])/2.0;
        }else {
            median = Double.valueOf(result[totalLength/2]);
        }

        return median;

    }

    public void mergeArrays(int[] result, int[] nums1, int[] nums2, int l1, int l2){

        int k=0, i=0, j=0;

        while(i<l1 && j<l2){
            if(nums1[i] > nums2[j]){
                result[k++] = nums2[j++];
            }else {
                result[k++] = nums1[i++];
            }
        }
        while(i<l1){
            result[k++] = nums1[i++];
        }
        while(j<l2){
            result[k++] = nums2[j++];
        }
    }

    public static void main(String[] args){
        MedianOfTwoArrays solution = new MedianOfTwoArrays();
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        double median = solution.findMedianSortedArrays(a, b);
        System.out.println(median);
    }

}
