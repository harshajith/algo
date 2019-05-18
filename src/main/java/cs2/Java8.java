package cs2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Harsha on 24/12/16.
 */
public class Java8 {

    public Java8() {
    }

    public void loopMap(){

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v) -> {
            System.out.println(v);
        });
    }

    public static void main(String[] args){

        List<String> lines = Arrays.asList("SAM", "PAT", "Hala");
        List<String> result = lines.stream().filter(name -> !name.equals("Hala")).collect(Collectors.toList());
        result.forEach(System.out::println);
        Java8 java8 = new Java8();
        java8.loopMap();
    }
}
