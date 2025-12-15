package javajvm;

import java.util.ArrayList;
import java.util.List;
/*
使用MAT工具分析OOM原因
设置以下jvm参数，在OOM的时候生成快照
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/heapdump.hprof

 */
public class HeapOOMDemo {

    static class BigObject {
        // 每个对象占用约 1MB 内存
        private byte[] data = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        List<BigObject> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new BigObject());
                count++;
                System.out.println("Created " + count + " objects");
                Thread.sleep(1); // 稍微慢一点，方便观察
            }
        } catch (OutOfMemoryError | InterruptedException e) {
            System.err.println("堆溢出！创建了 " + count + " 个对象");
            e.printStackTrace();
        }
    }
}
