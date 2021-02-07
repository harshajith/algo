import leetcode.jan.LongestPelindrom;
import org.junit.Before;
import org.junit.Test;

public class LongestPelindromeTest {

    LongestPelindrom longestPelindrom;
    @Before
    public void setup(){
        longestPelindrom = new LongestPelindrom();
    }

    @Test
    public void testPelindrom(){
        String result = longestPelindrom.longestPalindromeNew("abba");
        assert result.equals("abba");
    }

    @Test
    public void testPelindrom2(){
        String result = longestPelindrom.longestPalindromeNew("cbba");
        assert result.equals("bb");
    }

    @Test
    public void testPelindrom3(){
        String result = longestPelindrom.longestPalindromeNew("a");
        assert result.equals("a");
    }

    @Test
    public void testPelindrom4(){
        String result = longestPelindrom.longestPalindromeNew("ac");
        assert result.equals("c");
    }
}
