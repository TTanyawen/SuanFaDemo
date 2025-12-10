package basicTool.jihe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> l=new LinkedList<>();
        l.add(0);
        l.add(1);
        l.addFirst(3);
        l.addLast(5);
        System.out.println(l.toString());

    }
}
