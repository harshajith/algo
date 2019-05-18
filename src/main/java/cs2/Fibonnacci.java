package cs2;

import java.util.Date;

/**
 * Created by Harsha on 6/10/16.
 */
public class Fibonnacci {

    public static void main(String[] args){
        System.out.println("start time : " + new Date());
        for(int i=0; i<50;i++){
            System.out.println(fib(i));
        }
        System.out.println("end time : " + new Date());
    }




    public static int fib(int n){
        if(n <= 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

}
