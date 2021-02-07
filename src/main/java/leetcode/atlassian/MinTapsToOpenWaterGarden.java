package leetcode.atlassian;


/**
 * 1326. Minimum Number of Taps to Open to Water a Garden
 * Hard
 *
 * 485
 *
 * 52
 *
 * Add to List
 *
 * Share
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 *
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 *
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 *
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 */
public class MinTapsToOpenWaterGarden {

    public static void main(String[] args){
        int[] ranges = new int[]{3,4,1,1,0,0};
        System.out.println(minTaps1(5, ranges));
    }

    public static int minTaps1(int n, int[] ranges) {
        int[] maxRanges = new int[ranges.length];
        for(int i=0; i<ranges.length; i++){
            int left = i - ranges[i];
            int right = i + ranges[i];
            if(left >= 0) {
                maxRanges[left] = Math.max(maxRanges[left], right); // update the max length that can be be covered at left index.
            }else {
                maxRanges[i] = right;
            }
        }
        int taps = 1;
        int prev = 0;
        while(prev <= n){
            int range = maxRanges[prev];
            if(range <= n) {
                int maxIndex = 0, length = range;
                for(int i=prev; i<=range; i++){
                    if(maxRanges[i] > length){
                        length = maxRanges[i];
                        maxIndex = i;
                    }
                }
                prev = maxIndex;
                taps++;
            }else {
                return taps;
            }
        }
        return -1;
    }












    public static int minTaps(int n, int[] ranges) {
        int[] maxjump= new int[ranges.length];
        for(int i=0; i<ranges.length; i++){
            if(ranges[i]==0) continue;
            maxjump[i]= i+ranges[i];
            int left= Math.max(0,i-ranges[i]);
            maxjump[left]= Math.max(maxjump[left],i+ranges[i]);
        }
        if(maxjump[0]==0) return -1;
        int prev= 0, curr= maxjump[0], taps= 1;

        while(curr < n){
            int rangeMax = curr;
            for(int i=prev; i<=curr; i++){
                rangeMax = Math.max(rangeMax, maxjump[i]);
            }
            if(rangeMax == curr) return -1;
            prev = curr;
            curr = rangeMax;
            taps++;
        }
        return taps;
    }
}
