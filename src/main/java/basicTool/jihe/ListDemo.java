package basicTool.jihe;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        basicUse();
//        runAndModify();



    }
    //一边遍历一遍修改
    public static void runAndModify(){
        List<Integer> l=new ArrayList<>();
        //添加
        for(int i=0;i<10;i++){
            l.add(i+100);
        }

        //foreach 边遍历边修改--->会抛：ConcurrentModificationException
//        for(int i:l){
//            l.add(i*2);
//        }

        //普通遍历 边遍历边修改--->ok
//        int len=l.size();
//        for(int i=0;i<len;i++){
//            l.add(l.get(i)*2);
//        }

        //迭代器遍历 边遍历边修改--->会抛：ConcurrentModificationException
//        Iterator<Integer> it=l.iterator();
//        while(it.hasNext()){
//            l.add(it.next()*2);
//        }
    }

    // 基本使用
    public static void basicUse(){
        //创建
        List<Integer> l=new ArrayList<>();
        List<Integer> l2=new LinkedList<>();
        List<Integer> l3=new Vector<>();//线程安全但是性能差
        List<Integer> l4=new Stack<>();//stack已过时

        //添加
        for(int i=0;i<10;i++){
            l.add(i+100);
        }

        //遍历 :普通for & foreach & iterator
        for(int i=0;i<l.size();i++){
            System.out.print(l.get(i)+" ");
        }System.out.println();

        for(int i:l){
            System.out.print(i+" ");
        }System.out.println();

        Iterator<Integer> it=l.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }System.out.println();

        //修改旧的已经在list里面的值
        l.set(0,99);
        print(l,"1 修改后");

        //删除
        l.remove(5);//这里remove的是index=5的
        print(l,"2 删除后");

        l.remove(Integer.valueOf(101));//这里remove的是值为101的
        print(l,"3 删除后");

        //是否包含某元素
        System.out.println("contains(108)?:"+l.contains(108));

        //是否包含某集合
        System.out.println("contains(107,108)?:"+l.containsAll(Arrays.asList(107,108)));

        //某元素第一次和最后一次出现的位置
        l.add(104);
        System.out.println("indexOf(104):"+l.indexOf(104));
        System.out.println("lastIndexOf(104):"+l.lastIndexOf(104));

        //批量增加和删除
        l.addAll(Arrays.asList(1,2,3,4));
        l.removeAll(Arrays.asList(3,4,5,6));
        print(l,"批量增加和删除后");

        //清空全部元素
        l.clear();




    }

    public static <T> void print(Collection<T> collection,String comment){
        System.out.println(comment+" :");
        for(T t:collection){
            System.out.print(t+" ");
        }System.out.println();
    }
}
