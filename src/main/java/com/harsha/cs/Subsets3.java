package com.harsha.cs;

import java.util.Arrays;

/**
 * Gives you an int m, and a set of char (0,1,2,3,4,5,6,7,8,9)
 Lets you implement a function that generates a id based on the characters in the set.
 Each time you return a string, it must be unique.
 satisfying the same character can not appear consecutively more than m times,
 such as m = 3, "1000" is valid, "0000" is not valid.
 The smaller the string, the better.
 */
public class Subsets3 {



    public static void main(String[] args){
        int[] a = { 1,2,3} ;
        int m = 2;
        Subsets3 sb3 = new Subsets3();
        sb3.generateId(a, 2);

    }

    public  void generateId(int[] a, int m){
        int[] subset = new int[a.length * m];
        helper(a, subset, 0, 0, m);
    }


    public void helper(int[] a, int[] subset, int i, int p, int m){

        if(p == a.length){
            System.out.println(Arrays.toString(subset));
        }
        int val = a[p];
        subset[i] = 0;
        helper(a,subset,i+1, p, m);
        subset[i] = val;
        helper(a,subset,i+1, p, m);
//        for(int k=0; k<m; k++){
//            subset[i] = 0;
//            helper(a,subset,i+1, p, m);
//            subset[i] = val;
//            helper(a,subset,i+1, p, m);
//        }
        //helper(a, subset, i+1, p+1, m);

    }







}
