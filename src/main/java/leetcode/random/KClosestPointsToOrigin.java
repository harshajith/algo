package leetcode.random;

import java.util.*;

/**
 * 973. K Closest Points to Origin
 * Medium
 *
 * 1358
 *
 * 105
 *
 * Add to List
 *
 * Share
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args){
        int[][] input = new int[][]{
                {3,3},
                {5, -1},
                {-2,4}
        };
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] result = kClosestPointsToOrigin.kClosest(input, 2);
        for(int[] point: result){
            System.out.println(point[0] + " " + point[1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {

        int[][] result = new int[K][2];
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int x1 = o1.get(0);
                int y1 = o1.get(1);

                int x2 = o2.get(0);
                int y2 = o2.get(1);

                Integer val1 = x1*x1 + y1*y1;
                Integer val2 = x2*x2 + y2*y2;

                return val1.compareTo(val2);
            }
        };

        List<List<Integer>> queue = new ArrayList<>();

        for(int[] point: points){
            queue.add(Arrays.asList(point[0], point[1])); // n log(n)
        }
        Collections.sort(queue, comparator);
        int i = 0;
        Iterator<List<Integer>> iterator = queue.iterator(); // priority queue returns results in order based on the sorted order.
        while(i<K){
            List<Integer> point = iterator.next();
            result[i][0] = point.get(0);
            result[i++][1] = point.get(1);
        }
        return result;
    }

}
