package leetcodeApril;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * @param args
     */
    public static void main(String[] args){
        int[] a = new int[]{2,7,11,15};
        int target = 13;

//        Set<Integer> set = new HashSet<>();
//        for(int i=0; i<a.length; i++){
//            if(set.contains(target - a[i])){
//                System.out.println("found sum!");
//                break;
//            }else {
//                set.add(a[i]);
//                System.out.println("Item added to set");
//            }
//        }

        System.out.println(twoSum(a,13));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(indexMap.keySet().contains(target - nums[i])){
                result[0] = indexMap.get(target - nums[i]);
                result[1] = i;
                break;
            }else {
                indexMap.put(nums[i], i);
            }
        }
        return result;
    }

}
