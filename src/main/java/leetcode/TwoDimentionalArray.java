package leetcode;

public class TwoDimentionalArray {

    public static void main(String[] args){
        int[][] a = new int[][]{
                {1,2,2},
                {4,5,3},
                {4,6,7}
        };
        for(int i=0; i <= 2; i++){
            for(int j=0;j<=2;j++){
                System.out.println(a[i][j]);
            }
        }
    }
}
