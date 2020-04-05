package aws.s3;

import java.util.*;

public class CharacterPredictor {

    Map<Character, Map<Character, Integer>> graph = new HashMap<>();

    private void createGraph(char[] input){

        /**
         * O(n)
         */
        for(int i=0; i<input.length; i++){
            char newChar = input[i];
            if(i>0){
                char previousChar = input[i-1];
                Map<Character, Integer> adjacentMap = graph.get(previousChar);
                if(adjacentMap == null || adjacentMap.isEmpty()){
                    adjacentMap = new HashMap<>();
                    adjacentMap.put(newChar, 1);
                    graph.put(previousChar, adjacentMap);
                }else{
                    Integer count = adjacentMap.get(newChar);
                    if(count == null){
                        adjacentMap.put(newChar, 1);
                        graph.put(previousChar, adjacentMap);
                    }else {
                        adjacentMap.put(newChar, count+1);
                        graph.put(previousChar, adjacentMap);
                    }
                }
            }else {
                graph.put(newChar, new HashMap<>());
            }
        }
    }

    private char predictNextLetter(char in){
        Map<Character, Integer> map = graph.get(in);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        char possibleNextChar = list.get(0).getKey();
        return possibleNextChar;
    }


    public static void main(String[] args){
        char[] chars = new char[]{'A','B','C','D','A','B','D','A','C','F','C','D','D','B','A','C','A','C'};

        CharacterPredictor cp = new CharacterPredictor();
        cp.createGraph(chars);

        System.out.println("graph is populated");

        char prediction = cp.predictNextLetter('F');
        System.out.println("Prediction :::::: " + prediction);


    }


}
