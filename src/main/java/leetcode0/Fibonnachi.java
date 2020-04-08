package leetcode0;

public class Fibonnachi {

    public static void main(String[] args){
        System.out.println(fib(7));
    }

    private static long fib(int i){

        if(i == 0) return 0;
        if(i == 1) return 1;
        if(i == 2) return 1;

        return fib(i-1) + fib(i-2);

    }
}
