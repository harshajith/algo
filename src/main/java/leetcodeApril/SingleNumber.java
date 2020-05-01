package leetcodeApril;

public class SingleNumber {

    //All duplicates will be negated!
    public int singleNum(int[] nums){
        int a = 0;
        for(int i=0; i<nums.length; i++){
            a = a ^ nums[i];
        }
        return a;
    }

}
