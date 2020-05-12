package leetcode.may;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args){
        RansomNote ransomNote = new RansomNote();

        String ransom = "a";
        String magazine = "b";
        ransomNote.canConstruct(ransom, magazine);
    }


    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote == null || magazine == null) return false;

        Map<Character, Integer> ransomChars = new HashMap<>();
        for(Character c: ransomNote.toCharArray()){
            ransomChars.put(c, ransomChars.getOrDefault(c, 0) +1 );
        }

        Map<Character, Integer> magazineChars = new HashMap<>();
        for(Character c: magazine.toCharArray()){
            magazineChars.put(c, magazineChars.getOrDefault(c, 0) +1 );
        }

        for(Character ransom: ransomChars.keySet()){
            Integer ransomCharCount = ransomChars.get(ransom);
            Integer magazineCount = magazineChars.get(ransom);
            if(magazineCount == null || magazineCount < ransomCharCount){
                return false;
            }
        }
        return true;

    }
}
