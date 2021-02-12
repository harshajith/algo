package com.harsha.cs.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class TestCustomList {

    @Test
    public void testCustomList(){
        List<String> list = new CustomList<>();
        list.add("ab");
        list.add("axx");
        list.add("322");

        System.out.println(list.toString());
        for(String x: list){
            System.out.println(x);
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
