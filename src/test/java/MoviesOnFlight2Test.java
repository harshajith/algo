import leetcode.random.MoviesOnFlight2;
import org.junit.Test;

import java.util.List;

public class MoviesOnFlight2Test {

    MoviesOnFlight2 moviesOnFlight2 = new MoviesOnFlight2();

    @Test
    public void test1(){
        int[] durations = new int[]{90, 85, 75, 60, 120, 150, 125};
        List<Integer> movies = moviesOnFlight2.moviesOnFlight(250, durations);
        assert 90 == movies.get(0);
        assert 125 == movies.get(1);
    }
}
