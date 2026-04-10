package everythingcannotcategorize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
往ArrayList和LinkedList的头部插入1000个元素，哪一个更快?

理论上是LinkedList更快，因为ArrayList的插入操作是O(n)的，而LinkedList的插入操作是O(1)的
但是ArrayList在内存连续，cpu cache命中率很高

ArrayList head insert time: 650800 ns
LinkedList head insert time: 285400 ns

测试是LinkedList快
 */
public class arraylistlinkedlistinsertdemo {
    public static void main(String[] args) {
        int n = 1000;

        // ArrayList
        List<Integer> arrayList = new ArrayList<>();

        long start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(0, i);
        }
        long end1 = System.nanoTime();

        // LinkedList
        List<Integer> linkedList = new LinkedList<>();

        long start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(0, i);
        }
        long end2 = System.nanoTime();

        System.out.println("ArrayList head insert time: " + (end1 - start1) + " ns");
        System.out.println("LinkedList head insert time: " + (end2 - start2) + " ns");

    }
}
