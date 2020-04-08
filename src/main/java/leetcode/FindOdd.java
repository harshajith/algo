package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {

    /**
     * Brute force method
     * @param a
     * @return
     */
    public static int findIt(int[] a) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<a.length; i++){
            int val = a[i];
            if(map.get(val) == null) {
                map.put(val, 1);
            }else {
                map.put(val, map.get(val) + 1);
            }
        }

        for(int key: map.keySet()){
            int x = map.get(key);
            int y = x % 2;
            if(y == 1){
                return key;
            }
        }
        return 0;
    }

    /**
     * Optimised method
     * @param a
     * @return
     */
    private static int findOddOccurance(int[] a){
        int xor = 0;
        for(int i=0; i<a.length;i++) {
            xor ^= a[i];
        }
        return xor;
    }


    public static void main(String[] args){
        int[] array = new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5};
        int a = FindOdd.findIt(array);
        System.out.println(a);

        System.out.printf("result from xor:" + findOddOccurance(array));
    }


}


