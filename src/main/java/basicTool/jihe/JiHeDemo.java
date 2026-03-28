package basicTool.jihe;

//import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java集合体系
 * Collection-List&Set&Queue/Deque
 *  add/remove/addAll/removeAll
 *
 * ArrayList
 *  add/get/remove
 * LinkedList
 *  add/get/remove
 * HashSet
 *  add/contains
 * TreeSet
 *  add/first/last/higher/lower
 * Deque
 *  ArrayDeque/LinkedList
 *  offerFirst/offerLast/peekFirst/peekLast/pollFirst/pollLast
 *
 * PriorityQueue
 * offer/peek/poll
 *
 * Map
 * HashMap
 * TreeMap
 * put/get/containsKey/containsValue/entrySet/keySet
 *
 */
public class JiHeDemo {
    public static void main(String[] args) {
        //ArrayList
        //创建，可以传入Collection对象，可以用List.of创建固定大小的list
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>(list1);
        List<Integer> list3=Arrays.asList(1,2,3);
//        List<Integer> list4=List.of(1,2,3);
        //数组变list，list变数组
        int[] arr1={1,2,3};
//        List<Integer> list5=Arrays.stream(arr1).boxed().toList();
//        int[] arr2=list5.stream().mapToInt(Integer::intValue).toArray();

//        list5.get(1);
//        for(int num:list5){
//            System.out.println(num);
//        }
//        Iterator<Integer> it=list5.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        //LinkedList
        List<Integer> list6=new LinkedList<>();
        Set<Integer> set1=new HashSet<>();
        List<Integer> list7=new LinkedList<>(set1);
        list7.add(1);
        list7.add(1);
        list7.remove(1);
        list7.add(1);
        Integer i=1;
        list7.remove(i);
//        list7.addAll(List.of(1,2,3));
//        list7.removeAll(List.of(1,2,3));


        //HashSet
        Set<Integer> set2=new HashSet<>();
        set2.add(1);
        System.out.println(set2.contains(1));
        set2.remove(1);
//        set2.addAll(List.of(1,2,3));
//        set2.removeAll(List.of(1,2,3));
        Set<Integer> set3=new HashSet<>(Arrays.asList(1,2,3));
        for(Integer ele:set3){
            System.out.println(ele);
        }
        //set转数组
        int[] arr3=set3.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr3).forEach(System.out::println);

        //TreeSet
        TreeSet<int[]> treeSet=new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        treeSet.add(new int[]{3,6});
        treeSet.add(new int[]{4,8});
        treeSet.add(new int[]{1,2});
        treeSet.add(new int[]{2,4});


        for(int[] ele:treeSet){
            System.out.println(ele[0]);
        }
        treeSet.remove(new int[]{3,6});
        for(int[] ele:treeSet){
            System.out.println(ele[0]);
        }
        System.out.println(treeSet.last()[0]+","+treeSet.higher(new int[]{2,3})[0]);

        //Deque
        Deque<Integer> que=new LinkedList<>();
        que.offerFirst(1);
        que.offerLast(2);
        que.peekFirst();
        que.peekLast();
        que.pollFirst();
        que.peekLast();


        //PriorityQueue
        PriorityQueue<Integer> que2=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        que2.offer(1);
        que2.peek();
        que2.poll();


        // HashMap
        Map<String,Integer> map1=new HashMap<>();
        map1.put("1",1);
        map1.put("2",2);

        map1.merge("1",1,(a,b)->a+b);
        Set<Map.Entry<String,Integer>> entrySet=map1.entrySet();
        for(Map.Entry<String,Integer> ele:entrySet){
            System.out.println(ele.getKey()+","+ele.getValue());
        }
        //TreeMap
        TreeMap<String,Integer> treeMap1=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        treeMap1.put("a",1);
        treeMap1.put("b",1);
        treeMap1.put("c",1);
        for(String key:treeMap1.keySet()){
            System.out.println(key+","+treeMap1.get(key));
        }
        System.out.println(treeMap1.containsKey("a"));
        System.out.println(treeMap1.containsValue(1));
    }
}
