package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * MOVIES ON FLIGHT
 * You are on a flight and wanna watch two movies during this flight.
 * You are given int[] movie_duration which includes all the movie durations.
 * You are also given the duration of the flight which is d in minutes.
 * Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 * Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.
 *
 * e.g.
 * Input
 * movie_duration: [90, 85, 75, 60, 120, 150, 125]
 * d: 250
 *
 * Output from aonecode.com
 * [90, 125]
 * 90min + 125min = 215 is the maximum number within 220 (250min - 30min)
 */
public class MoviesOnFlight2 {

    public List<Integer> moviesOnFlight(int d, int[] movies){

        if(movies == null || movies.length == 0) return null;

        int maxDuration = 0;
        int x = 0, y = 0;

        for(int i=0; i<movies.length-1; i++){
            for(int j=i+1; j<movies.length; j++){
                int sum =  movies[i] + movies[j];
                if(sum <= (d-30) && sum > maxDuration){
                    x = movies[i];
                    y = movies[j];
                    maxDuration = sum;
                }
            }
        }
        return Arrays.asList(x, y);
    }

}
