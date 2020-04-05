package com.harsha.cs;

public class FB {

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1};

        rearrangeArray(a);
        for(int k=0; k < a.length; k++){
            System.out.println(a[k]);
        }

    }

    /**
     * O(n)
     * @param array
     */
    public static void rearrangeArray(int[] array) {
        int count = 0;
        int length = array.length;
        for(int i=0; i < length ; i++) {
            if(array[i] > 0){
                array[count] = array[i];
                array[i] = 0;
                count ++;
            }
        }
    }


    /**
     * O(n*n)
     * @param array
     */
    public static void rearrangeArray1(int[] array) {
        int length = array.length;
        for(int i=0; i < length ; i++) {
            if(array[i] == 0) {
                for(int j=i; j<length; j++) {
                    if(array[j] != 0) {
                        array[i] = array[j];
                        array[j] = 0;
                        break;
                    }
                }
            }
        }
    }

}
