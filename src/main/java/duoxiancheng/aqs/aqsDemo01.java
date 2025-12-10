package duoxiancheng.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class aqsDemo01 {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        lock.lock();

        lock.unlock();

    }
}
