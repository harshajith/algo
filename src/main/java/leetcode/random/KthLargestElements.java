package leetcode.random;

/**
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
public class KthLargestElements {

    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = mergeSort(nums, nums.length);

        int x = k;
        while(x>0){
            System.out.println(sortedArray[sortedArray.length-(x--)]);
        }

        return sortedArray[sortedArray.length-k];
    }



    private int[] mergeSort(int[] a, int length){

        if(a.length <2){
            return a;
        }

        int mid = length/2;
        int leftSize = mid;
        int rightSize = length - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for(int i=0; i<mid; i++){
            left[i] = a[i];
        }
        for(int i=mid; i<length; i++){
            right[i-mid] = a[i];
        }

        mergeSort(left, mid);
        mergeSort(right, length-mid);

        return merge(a, left, right, leftSize, rightSize);
    }

    private int[] merge(int[] a, int[] left, int[] right, int l, int r){

        int i=0; int j=0; int k=0;

        while(i<l && j<r){
            if(left[i] < right[j]){
                a[k++] = left[i++];
            }else {
                a[k++] = right[j++];
            }
        }
        while(i<l){
            a[k++] = left[i++];
        }
        while(j<r){
            a[k++] = right[j++];
        }
        return a;
    }

    public static void main(String[] args){
        KthLargestElements x = new KthLargestElements();
        int[] input = new int[]{3,2,3,1,2,4,5,5,6};
        int kthLargest = x.findKthLargest(input, 2);

        System.out.println("Kth largest element:" +kthLargest);


    }

}
