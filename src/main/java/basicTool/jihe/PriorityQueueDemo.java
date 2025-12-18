package basicTool.jihe;

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
        PriorityQueue<numCls> queue=new PriorityQueue<>();
        int[] arr={5,4,18,0,7,2};
        for(int i:arr){
            queue.offer(new numCls(i));
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll().val);

        }
    }
}
