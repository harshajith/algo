package com.harsha.cs.leetcode;

import leetcode.jan.AlienDirectory;
import org.junit.Test;

public class AlienDirectoryTest {

    @Test
    public void testAlienDirectory(){
        String[] words = new String[]{"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        AlienDirectory alienDirectory = new AlienDirectory();
        boolean isSorted = alienDirectory.isAlienSorted(words, order);
        assert isSorted == false;
    }

    @Test
    public void testAlienDirectory1(){
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        AlienDirectory alienDirectory = new AlienDirectory();
        boolean isSorted = alienDirectory.isAlienSorted(words, order);
        assert isSorted == true;
    }
}
