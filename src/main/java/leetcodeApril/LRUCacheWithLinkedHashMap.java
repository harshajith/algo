package leetcodeApril;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int maxSize;
    public LRUCacheWithLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.maxSize = capacity;
    }

    //return -1 if miss
    public int get(int key) {
        Integer v = super.get(key);
        return v == null ? -1 : v;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > maxSize; //must override it if used in a fixed cache
    }
}