package duoxiancheng;

import java.util.concurrent.atomic.AtomicStampedReference;
/*
AtomicStampedReference CAS的ABA问题
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<Integer> ref=new AtomicStampedReference<>(100,1);
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            int stamp=ref.getStamp();
            //ABA
            System.out.println(ref.compareAndSet(100,101,stamp,stamp+1));
            int newStamp=ref.getStamp();
            System.out.println(ref.compareAndSet(101,100,newStamp,newStamp+1));
        });
        Thread t2=new Thread(()->{
            int stamp=ref.getStamp();
            try{
                Thread.sleep(1000);//等t1模拟的ABA出现
            }catch(Exception e){

            }
            boolean success=ref.compareAndSet(100,2019,stamp,stamp+1);
            System.out.println("Success?:"+success);
            //Success?:false

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
