package com.harsha.cs.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr){

        int n = arr.length;
        for(int i = 0; i < n ; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {1,8,4,7,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
