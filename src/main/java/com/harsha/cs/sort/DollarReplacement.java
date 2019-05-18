package com.harsha.cs.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * if it is 12$$, how many unique combinations can be come up with replacing $
 */

public class DollarReplacement {

    public static void main(String[] args){
        String input = "12$$";
        solution(input);
    }


    public static void solution(String input){

        int splitIndex = input.indexOf("$");
        String dollarString = input.substring(splitIndex);
        String firstPart = input.substring(0, splitIndex);

        System.out.println(dollarString);
        System.out.println(firstPart);

        Set<Character> uniqueCharSet = convertToSet(firstPart);
        findCombinations(uniqueCharSet, firstPart, "", dollarString.length());

    }

    public static void findCombinations(Set<Character> charSet, String startStr, String subset, int limit){
        if(limit <= 0){
            System.out.println(startStr+subset);
            return;
        }
        for(Character character: charSet){
            subset = subset + "x"; // no pick
            limit = limit - 1;
            findCombinations(charSet,startStr, subset, limit);
            subset = subset + character.toString();
            findCombinations(charSet,startStr, subset, limit);

        }
    }


    public static Set convertToSet(String string) {

        // Result hashset
        Set resultSet = new HashSet();

        for (int i = 0; i < string.length(); i++) {
            resultSet.add(new Character(string.charAt(i)));
        }

        // Return result
        return resultSet;
    }

}
