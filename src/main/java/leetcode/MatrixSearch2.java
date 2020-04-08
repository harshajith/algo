package leetcode;

public class MatrixSearch2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;

        int m=matrix.length;
        int n=matrix[0].length;

        int i = n-1;

        while(i >= 0){
            if(matrix[0][i] > target){
                i--;
            }else {
                for(int j=0; j<m; j++){
                    if(matrix[j][i] == target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        MatrixSearch2 search2 = new MatrixSearch2();
        System.out.println(search2.searchMatrix(matrix, 19));

    }
}
