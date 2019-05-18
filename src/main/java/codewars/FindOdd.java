package codewars;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
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

    public static void main(String[] args){
        int a = FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5});
        System.out.println(a);
    }
}


