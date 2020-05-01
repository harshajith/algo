import leetcode.random.LongestCommonSubsequence;
import org.junit.Test;

public class LCSTest {

    @Test
    public void test(){
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.LCS(text1, text2);

        assert result == 3;
    }

    @Test
    public void test2(){
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.LCS(text1, text2);

        assert result == 4;
    }
}
