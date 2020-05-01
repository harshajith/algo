import leetcodeApril.FirstUnique;
import org.junit.Test;

public class FirstUniqueTest {


    @Test
    public void test1(){

        int[] input = new int[]{2,3,5};
        FirstUnique firstUnique = new FirstUnique(input);
        assert 2 == firstUnique.showFirstUnique();
        firstUnique.add(5);
        assert 2 == firstUnique.showFirstUnique();
        firstUnique.add(2);
        assert 3 == firstUnique.showFirstUnique();
        firstUnique.add(3);
        assert -1 == firstUnique.showFirstUnique();
    }
}
