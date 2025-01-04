package leetcode.twopointer;

import java.util.*;

public class LRUCache {

    private Map<Integer, Integer> cache;
    private int capacity;
    private List<Integer> seqQue;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        seqQue = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        if (cache.containsKey(key)) {
            seqQue.remove((Integer) key);
            seqQue.add(key);
        }
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            seqQue.remove((Integer) key);
        }

        else if (seqQue.size() == capacity) {
            Integer oldKey = seqQue.remove(0);
            cache.remove(oldKey);
        }

        cache.put(key, value);
        seqQue.add(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
