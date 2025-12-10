package duoxiancheng;

import java.util.LinkedList;
import java.util.Queue;

// synchronized + wait/notify 实现生产者消费者模式
// buffer.wait后，当前线程会释放锁，并进入Waiting状态
// buffer.notify后，在等待队列的线程会进入Blocking状态，当争抢锁成功后回到Running状态
public class ThreadDemo01 {
    private final Queue<Integer> buffer=new LinkedList<>();
    private final int capacity=5;

    public void produce() throws InterruptedException{
        int value=0;
        while(true){
            synchronized (buffer){
                while(buffer.size()==capacity){//这里用while是因为线程可能会“假醒”，所以需要再次做判断
                    buffer.wait();
                }
                buffer.add(value);
                System.out.println("Produced: "+value);
                value++;
                buffer.notify();
            }
            Thread.sleep(500);//模拟生产时间
        }
    }
    public void consume() throws InterruptedException{
        while(true){
            synchronized (buffer){
                while(buffer.isEmpty()){
                    buffer.wait();
                }
                int value=buffer.poll();
                System.out.println("Consumed: " + value);
                buffer.notify();
            }
            Thread.sleep(1000);//模拟消费时间
        }
    }

    public static void main(String[] args) {
        ThreadDemo01 obj=new ThreadDemo01();

        new Thread(()->{
            try{
                obj.produce();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                obj.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
