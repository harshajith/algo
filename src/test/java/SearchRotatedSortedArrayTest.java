import leetcodeApril.SearchRotatedSortedArray;
import org.junit.Test;

public class SearchRotatedSortedArrayTest {

    SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();

    @Test
    public void test1(){
        int[] input = new int[]{4,5,6,7,0,1,2};
        int result = searchRotatedSortedArray.search(input, 1);
        assert result == 5;
    }

    @Test
    public void test2(){
        int[] input = new int[]{4,5,6,7,0,1,2};
        int result = searchRotatedSortedArray.search(input, 3);
        assert result == -1;
    }
}
