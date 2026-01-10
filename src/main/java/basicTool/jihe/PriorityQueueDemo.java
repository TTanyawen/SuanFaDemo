package basicTool.jihe;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class numCls implements Comparable<numCls>{
    int val;

    public numCls(int val) {
        this.val = val;
    }


    @Override
    public int compareTo(numCls o) {
        return this.val-o.val;
    }
}
public class PriorityQueueDemo {

    public static void main(String[] args) {
//        f1();
        f2();

    }
    public static void f1() {
        PriorityQueue<numCls> queue=new PriorityQueue<>();
        int[] arr={5,4,18,0,7,2};
        for(int i:arr){
            queue.offer(new numCls(i));
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll().val);

        }
    }
    public static void f2() {

        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);
        queue.offer(3);
        queue.offer(2);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
// 默认是小根堆
//        1
//        2
//        3
//        5

    }

}
