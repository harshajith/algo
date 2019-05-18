package com.harsha.cs;

public class Subsets2 {

    public void findSubsets(int[] a){
        int n = a.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(a[j] + " ");

            System.out.println("}");
        }

    }


    public static void main(String[] args){
        int[] a = new int[4];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;

        Subsets2 subsets2 = new Subsets2();
        subsets2.findSubsets(a);
    }

}
