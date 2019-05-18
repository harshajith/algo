package cs2;

import java.util.Date;

/**
 * Created by Harsha on 12/5/17.
 */
public class DynamicProgramMemorization {

    private int[] memory = null;


    public DynamicProgramMemorization(int n){
        memory = new int[n];
        System.out.println("start time : " + new Date());
        for(int i=0; i<100;i++){
            System.out.println(fib(i));
        }
        System.out.println("end time : " + new Date());
    }

    public int fib(int n){
        if(n==0) {
            return 0;
        } else if( n == 1){
            return 1;
        } else {
            if(memory[n] == 0){
                memory[n] = fib(n-1) + fib(n-2);
            }
            return memory[n];
        }
    }

    public static void main(String[] args){
        DynamicProgramMemorization program = new DynamicProgramMemorization(100);

    }

}
