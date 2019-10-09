package aws.s3;


import java.util.*;

/**
 * I had 2 question on my online assesment, however I remeber only the first one. My code passed only 10 test out of 13. I did a sorting and then found the best pair with 2 for loops
 *
 * Question:
 * You are on a flight and wanna watch two movies during this flight.
 * You are given List<Integer> movieDurations which includes all the movie durations.
 * You are also given the duration of the flight which is d in minutes.
 * Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 *
 * Find the pair of movies with the longest total duration and return they indexes. If multiple found, return the pair with the longest movie.
 *
 * Example 1:
 *
 * Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
 * Output: [0, 6]
 * Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)
 */
public class MoviesOnFlight {

    public static void main(String[] args){
        int[] movies = new int[]{90, 85, 75, 60, 120, 150, 125};
        MoviesOnFlight moviesOnFlight = new MoviesOnFlight();
        List<Integer> res = moviesOnFlight.findTwoMovies(movies, 250);
        for(Integer i: res) System.out.println(i);
    }

    public List<Integer> findTwoMovies(int[] input, int d){

        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i<input.length; i++){
            indexMap.put(input[i], i);
        }

        Arrays.sort(input);
        int sum = Integer.MIN_VALUE;
        int first = -1;
        int last = -1;

        int i=0, j=input.length-1;

        while(i<j){
            int a = input[i];
            int b = input[j];

            int total = a+b;
            if(total <= d-30) {
                if(total > sum){
                    sum = total;
                }
                first = i++;
                last = j;
            }else {
                j--;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(indexMap.get(input[first]));
        res.add(indexMap.get(input[last]));
        return  res;
    }


}
