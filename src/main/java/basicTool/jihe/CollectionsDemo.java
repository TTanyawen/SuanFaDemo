package basicTool.jihe;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> l= Arrays.asList(2,1,3);
        Collections.sort(l);

        List<List<Integer>> l2=new ArrayList<>();
        l2.add(Arrays.asList(2,3));
        l2.add(Arrays.asList(1,2));
        l2.add(Arrays.asList(4,5));

        Collections.sort(l2, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });

        Collections.sort(l2, (o1, o2) -> o1.get(0)-o2.get(0));
        System.out.println(l2.toString());

        //线程安全包装
        List<Integer> l3=Collections.synchronizedList(new ArrayList<>());

        //批量添加
        Collections.addAll(l3,1,2,3,4);
        l3.addAll(Arrays.asList(5,6,7));//相当于这一个
        System.out.println(l3.toString());

        //整体右移(可以达到反转效果)
        Collections.rotate(l3,2);
        System.out.println(l3.toString());
        Collections.rotate(l3,5);
        System.out.println(l3.toString());


    }
}
