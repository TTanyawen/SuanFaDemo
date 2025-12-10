package basicTool.jihe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.putIfAbsent("1",2);//key空才会加入

        System.out.println(map.get("1"));

        map.put("1",2);
        System.out.println(map.get("1"));

        //遍历
        Set<Map.Entry<String,Integer>> set=map.entrySet();
        for(Map.Entry<String,Integer> entry:set){
            System.out.println(entry.getKey()+","+entry.getValue());
        }

        Set<String> set2=map.keySet();
        for(String key:set2){
            System.out.println(key);
        }

        Collection<Integer> set3=map.values();
        for(Integer val:set3){
            System.out.println(val);
        }

        List<Integer> list=new ArrayList<>(map.values());

        map.remove("2");
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue(1));

        System.out.println(map.size());
        System.out.println(map.isEmpty());

        map.forEach((k, v) -> System.out.println(k+","+v));

        ConcurrentHashMap<String,Integer> mm=new ConcurrentHashMap<>();

    }
}
