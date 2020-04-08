package leetcode30Challenge;

import java.util.HashSet;

public class HappyNumber {


    public void printInSequence(int n){

        int current = n;
        while(current != 0){
            System.out.println(current % 10);
            current = current / 10;
        }

    }


    public boolean isHappy1(int n){
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            int current = n;
            int sum = 0;
            while(current != 0){
                sum += (current % 10) * (current % 10);
                current = current / 10;
            }
            if(seen.contains(sum)){
                return false;
            }

            seen.add(sum);
            n = sum;
        }
        return true;
    }


    public boolean isHappy(int n) {
        String a = String.valueOf(n);
        int sum = 0;
        for(int i=0; i<a.length(); i++){
            final int i1 = Integer.parseInt(a.substring(i, i + 1));
            sum += i1 * i1;
        }
        if(sum == 1) {
            return true;
        }else {
            return isHappy(sum);
        }
    }

    public static void main(String[] args){
        HappyNumber h = new HappyNumber();
        //System.out.println(h.isHappy1(54));
        h.printInSequence(1236784);
    }
}
