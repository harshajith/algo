package aws.s3;


import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Divide and Conquer method.
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        MergeSort.mergeSort(actual, actual.length);

        for(int i=0; i< actual.length; i++){
            System.out.println(actual[i]);
        }
    }

    private static void mergeSort(int[] actual, int length) {

        if(length < 2){
            return;
        }
        // split into two halves
        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length-mid];

        for(int i=0; i<mid; i++){
            left[i] = actual[i];
        }
        for(int i=mid; i< length; i++){
            right[i-mid] = actual[i];
        }

        mergeSort(left, mid);
        mergeSort(right, length-mid);

        merge(actual, left, right, mid, length-mid);

    }

    private static void merge(int[] actual, int[] left, int[] right, int leftLength, int rightLength) {

        int k=0, i = 0,j = 0;
        while(i<leftLength && j<rightLength){
            if(left[i] <= right[j]){
                actual[k++] = left[i++];
            }else {
                actual[k++] = right[j++];
            }
        }

        while(i< leftLength){
            actual[k++] = left[i++];
        }

        while(j < rightLength){
            actual[k++] = right[j++];
        }
    }

}
