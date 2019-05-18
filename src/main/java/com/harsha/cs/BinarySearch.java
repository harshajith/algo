package com.harsha.cs;


public class BinarySearch {

    private static int[] arr;

    static {
        arr = new int[7];
        arr[0] = 3;
        arr[1] = 4;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 8;
        arr[5] = 10;
        arr[6] = 13;
    }



    public static void main(String[] args){
        System.out.println(binSearch(0, 6, 5));
    }


    /**
     * Complexity log(n)
     * @param l
     * @param r
     * @param value
     * @return
     */
    private static int binSearch(int l, int r, int value){
        if(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == value){
                return mid;
            }else if(arr[mid] > value){
                return binSearch(l, mid-1, value);
            }else {
                return binSearch(mid+1, r, value);
            }
        }else {
            return -1;
        }
    }
}
