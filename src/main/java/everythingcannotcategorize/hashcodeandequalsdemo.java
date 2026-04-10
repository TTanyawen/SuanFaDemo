package everythingcannotcategorize;

import java.util.HashSet;
import java.util.Set;

public class hashcodeandequalsdemo {
    public static void main(String[] args) {
        Object obj1=new Object();
        Object obj2=new Object();
        Object obj3=new Object();
        Object obj4=new Object();
        Object obj5=new Object();
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());
        System.out.println(obj5.hashCode());
        System.out.println(obj1.equals(obj2));
        /*
        Object里边是 public native int hashCode();
            hotspot好像可以控制不同的生成策略：基于线程随机数，全局自增，混合算法，
            所以hashCode并不一定直接根据内存地址来算的

            开全局自增
            -XX:hashCode=1

            打印：（都是紧挨着的数字，不过顺序会打乱一点，可能是指令重排什么的？）
            1793378836
            1793378842
            1793378840
            1793378846
            1793378844
        equals不重写就跟==一样，比较的是首地址
        public boolean equals(Object obj) {
        return (this == obj);
    }

         */
        hashcodeandequalsdemoClass1 hashcodeandequalsdemoClass1 = new hashcodeandequalsdemoClass1();
        hashcodeandequalsdemoClass1 hashcodeandequalsdemoClass2 = new hashcodeandequalsdemoClass1();
        Set<hashcodeandequalsdemoClass1> set = new HashSet<>();
        set.add(hashcodeandequalsdemoClass1);
        set.add(null);//放在index=0处
        set.add(hashcodeandequalsdemoClass2);
        System.out.println(set.size());//2
        System.out.println(hashcodeandequalsdemoClass1.equals(hashcodeandequalsdemoClass2));//true
        System.out.println(set.contains(hashcodeandequalsdemoClass1));//true
        System.out.println(set.contains(hashcodeandequalsdemoClass2));// true,contains也是用equals来算的
        System.out.println(set.contains(null));//true



    }
}
class hashcodeandequalsdemoClass1{
    @Override
    public int hashCode() {
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}