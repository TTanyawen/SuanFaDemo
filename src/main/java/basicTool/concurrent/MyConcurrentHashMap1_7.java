package basicTool.concurrent;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
/*
分若干个segment
每一个segment对应一个hashMap
segment extends了ReentrantLock，可以对segment对象加锁
hash运算确定segmentIndex
put的时候Segment粒度加锁
get不加锁(1.7)
 */
public class MyConcurrentHashMap1_7<K,V> {
    private static final int SEGMENT_N=16;
    private final Segment<K,V>[]segments;
    static class Segment<K,V> extends ReentrantLock{
        HashMap<K,V> map=new HashMap<>();
    }
    @SuppressWarnings("unchecked")
    public MyConcurrentHashMap1_7() {
        segments = new Segment[SEGMENT_N];
        for (int i = 0; i < SEGMENT_N; i++) {
            segments[i] = new Segment<>();
        }
    }
    // 根据hash定位Segment
    private int getSegmentIndex(Object key) {
        int hash = key.hashCode();
        return (hash ^ (hash >>> 16)) & (SEGMENT_N - 1);
    }
    public void put(K key, V value) {
        int index = getSegmentIndex(key);
        Segment<K, V> segment = segments[index];

        segment.lock(); // 加锁
        try {
            segment.map.put(key, value);
        } finally {
            segment.unlock();
        }
    }

    public V get(K key) {
        int index = getSegmentIndex(key);
        return segments[index].map.get(key); // 读不加锁（类似1.7）
    }

}
