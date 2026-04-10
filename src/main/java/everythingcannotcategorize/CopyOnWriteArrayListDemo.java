package everythingcannotcategorize;

import java.util.concurrent.CopyOnWriteArrayList;
/*
        写操作：加锁->复制整个数组->写副本数组->更新引用->释放锁
        读操作：读旧数组

        适合读多写少场景

        内部一个数组用来存储元素，执行变更操作，先加锁，创建副本，修改副本，更新引用
        读操作在原本的数组进行
*/
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        new Thread(() -> {
            list.add("D");
            System.out.println(list);
        }).start();
        new Thread(() -> {
            list.add("E");
            System.out.println(list);
        }).start();

    }
}
