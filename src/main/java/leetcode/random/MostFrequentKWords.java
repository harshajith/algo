package leetcode.random;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentKWords {

    List<String> retrieveMostFrequentlyUsedWords(String helpText,
                                                 List<String> wordsToExclude)
    {

        Set<String> exclusionSet = new HashSet<>(wordsToExclude.stream().map(word -> word.toLowerCase()).collect(Collectors.toList()));

        List<String> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();

        String[] txts = helpText.split(" ");

        for(String str: txts){
            String word = str.toLowerCase();
            if(!exclusionSet.contains(word)){
                wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
            }
        }


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };


        Map<Integer, List<String>> treeMap = new TreeMap<>(comparator);
        for(String word: wordMap.keySet()){
            int frequency = wordMap.get(word);
            List<String> words = treeMap.get(frequency);
            if(words == null){
                treeMap.put(frequency, Arrays.asList(word));
            }else {
                words.add(word);
                treeMap.put(frequency, words);
            }
        }

        int i=0;
        for(Integer first: treeMap.keySet()){
            result =  treeMap.get(first);
            i++;
            if(i == 1){
                break;
            }
        }

        return result;

    }

}
