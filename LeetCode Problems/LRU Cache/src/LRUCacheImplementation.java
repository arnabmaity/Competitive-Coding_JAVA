import java.util.*;

class LRUCache {
    Map<Integer, Integer> cache;
    private final int CACHE_SIZE;

    public LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        cache = new LinkedHashMap<>(CACHE_SIZE);
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        else {
            int value = cache.get(key); // since it is the last accesses so setting that according to it
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) { // modifying the key element
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if(cache.size()==CACHE_SIZE) { // if key is not present then check for size
            int keyToRemove = cache.entrySet().iterator().next().getKey();
            cache.remove(keyToRemove);
        }
        cache.put(key, value);
    }
}


public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache lruCacheImplementation = new LRUCache(2);
        lruCacheImplementation.get(2);
        lruCacheImplementation.put(2, 6);
        lruCacheImplementation.get(1);
        lruCacheImplementation.put(1, 5);
        lruCacheImplementation.put(1, 2);
        lruCacheImplementation.get(1);
        lruCacheImplementation.get(2);
        return;
    }
}
