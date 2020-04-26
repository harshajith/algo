import leetcode30Challenge.LRUCache;
import org.junit.Test;

public class LRUCacheTest {

    LRUCache cache = new LRUCache(2);


    @Test
    public void test1(){
        cache.put(1, 1);
        cache.put(2, 2);
        assert 1 == cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        assert -1 == cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        assert -1 == cache.get(1);       // returns -1 (not found)
        assert 3 == cache.get(3);       // returns 3
        assert 4 == cache.get(4);       // returns 4
    }


    @Test
    public void test2(){
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assert -1 == cache.get(1);
        assert 3 == cache.get(2);       // returns -1 (not found)

    }


}
