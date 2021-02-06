package leetcode.jan;


/**
 * /**
 *  * Let’s say you have two input arrays with sorted elements. Find the union.
 *
 *  a[] = {2, 10, 14, 19, 51, 71}
 *  b[] = {2, 9, 19, 40, 51}
 *
 *  Union = {2, 9, 10, 14, 19, 40, 51}
 *
 *  */

import java.util.ArrayList;

public class AmazonTest1 {

    public int[] union(int[] a, int[] b){
        ArrayList<Integer> unionList = new ArrayList<>();
        int i=0, j=0;

        while(i<a.length && j<b.length){
            if(a[i] < b[j]){
                unionList.add(a[i++]);
            }else if(a[i] > b[j]){
                unionList.add(b[j++]);
            }else {
                unionList.add(a[i++]);
                j++;
            }
        }

        while(i<a.length){
            unionList.add(a[i++]);
        }

        while(j<b.length){
            unionList.add(b[j++]);
        }

        int[] result = new int[unionList.size()];
        for(int x=0; x<unionList.size(); x++){
            result[x] = unionList.get(x);
        }
        return result;
    }
}
