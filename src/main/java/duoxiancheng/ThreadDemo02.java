package duoxiancheng;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 使用ReentrantLock和Condition 实现生产者和消费者
public class ThreadDemo02 {
    private final Queue<Integer> buffer=new LinkedList<>();
    private final int capacity=5;

    private final Lock lock=new ReentrantLock();
    private final Condition notFull=lock.newCondition();
    private final Condition notEmpty= lock.newCondition();

    public void produce() throws InterruptedException{
        int value=0;
        while(true){
            lock.lock();
            try{
                while(buffer.size()==capacity){
                    notFull.await();
                }
                buffer.add(value);
                System.out.println("Produced: " + value);
                value++;
                notEmpty.signal();
            }finally {
                lock.unlock();
            }
            Thread.sleep(500);

        }
    }
    public void consume() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (buffer.isEmpty()) {
                    notEmpty.await(); // 等待缓冲区有数据
                }
                int value = buffer.poll();
                System.out.println("Consumed: " + value);
                notFull.signal(); // 通知生产者
            } finally {
                lock.unlock();
            }
            Thread.sleep(1000); // 模拟消费时间
        }
    }
    public static void main(String[] args) {
        ThreadDemo02 pc = new ThreadDemo02();

        new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
