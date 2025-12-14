package javajvm;

/*
    xms：初始堆大小
        默认时物理内存的1/64
    xmx：最大堆大小
        默认时物理内存的1/4
    xss：每个线程对应的栈大小
        64位 Windows默认为1MB
 */
public class StackAndHeapDemo {
    public static void main(String[] args) {

        //观察堆Xmx和Xms
        /*
            4223664128 bytes
                ≈ 4028 MB
                ≈ 3.93 GB
            264241152 bytes
                ≈ 252 MB


            设置xmx和xms
                -Xms512m
                -Xmx512m
            536870912
                =512 MB
            536870912
                =512 MB
         */
        System.out.println(Runtime.getRuntime().maxMemory());   // ≈ Xmx
        System.out.println(Runtime.getRuntime().totalMemory()); // ≈ Xms（运行时可能已扩容）

        //观察栈大小
        StackDepthTest test=new StackDepthTest();
        test.f();
        /*
            默认Xss：1m
                Depth = 18264
                java.lang.StackOverflowError

            设置Xss=2m(在Run/Debug Configuration中设置)
                Depth = 40282
                java.lang.StackOverflowError
        */

        /*
            运行时候，调用jps -l找到线程id
            调用jstat -gc [id]

             S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
              0.0   0.0    0.0    0.0   27648.0   5120.0   496640.0    3072.0   640.0  439.6  128.0   21.9       0    0.000   0      0.000    0.000
            S0C S1C : Survivor 0/1 capacity
            SOU S1U : Survivor 0/1 used
            EC : Eden capacity
            EU : Eden used
            OC : Old capacity
            OU : Old used
            MC/MU ：: Metaspace capacity and used

            YGC : Minor GC 次数
            YGCT : Minor GC 总用时
            FGC/FGCT : Full GC 次数/用时
            GCT : 所有GC总用时


         */


    }
}
class StackDepthTest {
    int depth = 0;

    void f() {
        try {
            recurse();
        } catch (Throwable e) {
            System.out.println("Depth = " + depth);
            e.printStackTrace();

        }
    }

    void recurse() throws InterruptedException {
        depth++;
        Thread.sleep(500);
        recurse();
    }
}
