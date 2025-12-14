package javajvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
    四种引用类型
 */
public class YingYongDemo {
    public static void main(String[] args) {
        /*
            强引用
                只要存在强引用，就不会被GC
         */
        Object obj1=new Object();

        /*
            软引用
                只有内存空间不足，才被回收
         */


        Object obj2 = new Object();
        SoftReference<Object> soft = new SoftReference<>(obj2);

        obj2 = null;  // 只有软引用指向
        System.gc();

        Object o = soft.get(); // 如果内存充足，o 不为 null；内存紧张可能被回收


        /*
            弱引用
                下一次GC就被回收
         */
        Object obj3 = new Object();             // 强引用
        WeakReference<Object> weak = new WeakReference<>(obj3);

        System.out.println(weak.get() != null); // true

        obj3 = null;                            // 去掉强引用
        System.gc();                           // 下一次 GC
        System.out.println(weak.get() != null); // false，对象已回收

        /*
            虚引用
                仅仅为了在对象回收的时候做一些别的操作
         */


        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        Object obj4 = new Object();
        PhantomReference<Object> phantom = new PhantomReference<>(obj4, queue);

        obj4 = null;    // 对象可回收
        System.gc();

        if(queue.poll() != null){
            System.out.println("对象即将被回收，可以做清理操作");
        }

    }
}
