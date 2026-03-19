package basicTool.concurrent;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

/*
没法对HashMap直接改，拿不到数组
写一个数组，写一个Node模拟链表
put 先CAS再sychronized锁桶头
get 不加锁，如果树在被写，降级为链表查
 */
public class MyConcurrentHashMap1_8<K, V> {

    static class Node<K, V> {
        final int hash;
        final K key;
        volatile V value;
        volatile Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    volatile Node<K, V>[] table;

    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public MyConcurrentHashMap1_8() {
        table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
    }

    private int hash(Object key) {
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }


    public V get(Object key) {
        Node<K, V>[] tab = table;
        int h = hash(key);
        int index = (tab.length - 1) & h;

        Node<K, V> e = tab[index];
        while (e != null) {
            if (e.hash == h && Objects.equals(e.key, key)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }


    public V put(K key, V value) {
        int h = hash(key);

        for (;;) {
            Node<K, V>[] tab = table;
            int index = (tab.length - 1) & h;

            Node<K, V> first = tab[index];

            // 空桶 → CAS
            if (first == null) {
                Node<K, V> newNode = new Node<>(h, key, value, null);

                if (casTabAt(tab, index, null, newNode)) {
                    return null;
                }
                // CAS失败 → 重试
            } else {
                // 冲突 → 锁桶
                synchronized (first) {
                    Node<K, V> e = first;

                    while (true) {
                        // key存在 → 覆盖
                        if (e.hash == h && Objects.equals(e.key, key)) {
                            V old = e.value;
                            e.value = value;
                            return old;
                        }

                        if (e.next == null) {
                            e.next = new Node<>(h, key, value, null);
                            return null;
                        }

                        e = e.next;
                    }
                }
            }
        }
    }


    private boolean casTabAt(Node<K, V>[] tab, int i,
                             Node<K, V> expect,
                             Node<K, V> update) {
        synchronized (this) { // 简化版CAS
            if (tab[i] == expect) {
                tab[i] = update;
                return true;
            }
            return false;
        }
    }
}
