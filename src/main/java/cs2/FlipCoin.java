package cs2;

public class FlipCoin {
    public static void main(String[] args) {
        int[] A = {1, 1, 0, 1, 0, 0, 1, 1};
        System.out.println(new FlipCoin().solution(A) );
    }

    public int solution(int[] A) {
        boolean flipped = false;
        int adjacency = 0;
        for(int i=1; i<A.length-1; i++) {
            if(A[i] == A[i-1]) adjacency++;
            else if(A[i-1] == A[i+1] && !flipped) {
                flipped = true;
                adjacency += 2;
                i++;
            }
        }

        if(flipped ) {
            if(A[A.length-1] == A[A.length-2]) adjacency++;
        } else {
            if(A[A.length-1] != A[A.length-2]) adjacency++;
            else if(A[0] != A[1] ) adjacency+=2;
        }

        return adjacency;
    }
}


