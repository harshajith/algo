package com.harsha.cs.sort;

import java.util.Arrays;

/**
 * divide and conquor method
 * divide into two and sort them in the merge step.
 */
public class MergeSort {


    /**
     * Complexity
     * @param a
     * @param n
     */
    public void mergeSort(int[] a, int n){

        if(n < 2) {
            return ;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        // Make left array
        for(int i=0; i<mid; i++){
            left[i] = a[i];
        }

        // Make right array
        for(int i=mid; i<n; i++){
            right[i-mid] = a[i];
        }


        mergeSort(left, mid); // split left array again
        mergeSort(right, n-mid); // split right array again
        merge(a, left, right); // merge left and right arrays

    }

    private void merge(int[] a, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                a[k++] = left[i++];
            }else {
                a[k++] = right[j++];
            }
        }

        while(i < left.length){
            a[k++] = left[i++];
        }

        while(j < right.length) {
            a[k++] = right[j++];
        }
    }


    public static void main(String[] args){
        int[] a = new int[7];
        a[0] = 4;
        a[1] = 43;
        a[2] = 4;
        a[3] = 2;
        a[4] = 9;
        a[5] = 7;
        a[6] = 2;


        MergeSort q = new MergeSort();
        q.mergeSort(a, a.length);

        System.out.println(Arrays.toString(a));

    }


}
