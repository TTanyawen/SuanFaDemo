//package hot100;
//
//import java.util.*;
//
//public class AT2 {
//    public static void main(String[] args) {
////        int[] arr={1,6,1,1,4,4};
//        int[] arr={};
//        System.out.println(MinimalSizeOfArray(arr));
//    }
//    public static int MinimalSizeOfArray(int[] a) {
//        // write code here
//        Map<Integer,Integer> m=new HashMap<>();
//        //统计个数
//        for(int num:a){
//            m.merge(num,1,(i,j)->i+j);
//        }
//        PriorityQueue<Integer> que=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        for(Integer ele:m.values()){
//            que.offer(ele);
//        }
////        List<Integer> list=new ArrayList<>();
////        for(Integer ele:m.values()){
////            list.add(ele);
////        }
////        Collections.sort(list,(i,j)->i-j);//DESC
//
//        while(que.size()>1){
////            System.out.println(que.size());
//            int first=que.poll();
//            int second=que.poll();
////            list.remove(0);
////            list.remove(1);
//            que.offer(first-second);
////            Collections.sort(list,(i,j)->i-j);
//        }
//        return que.isEmpty()?0:que.poll();
//
//
//    }
//}
