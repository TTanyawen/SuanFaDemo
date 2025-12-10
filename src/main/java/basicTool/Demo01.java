package basicTool;

import java.util.*;


public class Demo01 {
    public static void main(String[] args) {
        //HashMap常用
        Map<Integer,Integer> m= new HashMap<>();
        m.put(1,2);

        System.out.println(m.get(1));
        System.out.println(m.get(3));

        System.out.println(m.containsKey(1));
        System.out.println(m.containsKey(3));
        System.out.println(m.containsValue(3));
        System.out.println(m.size());

        //HashSet常用
        Set<Integer> s=new HashSet<>();
        s.add(1);
        s.contains(1);

        List<String> list=new ArrayList<>();

        String ss="sss";
        System.out.println(ss.length());

        List<List<String>> res= new ArrayList<>();

    }
}
