//package hot100;
//
//import java.util.*;
//
///*
//5
//2 0 0 0 3
//
//10
//10 0 0 0 0 0 0 0 0 0
//
//3
//14 7 0
//
//3
//21 7 0
//
//7
//0 0 4 4 4 5 4
//
//3
//1 1 1
//
//4
//23 25 27 21
//
//5
//6 6 6 7 5
//10
//45 67 32 4 1 6 0 8 4 3
// */
//public class AT0311_2 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] arr=new int[n];
//        long sum=0;
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//            sum+=arr[i];
//        }
//        if(sum%n!=0){
//            System.out.println(-1);
//            return;
//        }
//
//        int target= (int) (sum/n);//每个宝箱需要达到的数字
//        //map 存映射关系
////        Map<Integer,Integer> m=new HashMap<>();//num，times
//        //priorityQueue取最大最小
//
//        PriorityQueue<Integer> maxQue=new PriorityQueue<>((a,b)->b-a);
//        PriorityQueue<Integer> minQue=new PriorityQueue<>((a,b)->a-b);
//        for(int i=0;i<=n-1;i++){
//            if(arr[i]!=target){
////                m.merge(arr[i],1,(a,b)->a+b);
//                minQue.add(arr[i]);
//                maxQue.add(arr[i]);
//            }
//        }
//
//
//        //处理queue
//        /*
//            0 0 0 2 3
//            3 2 0 0 0
//            target=1
//         */
//        int res=0;
//        while(!minQue.isEmpty()&&!maxQue.isEmpty()){
//            int minN=minQue.poll();
//            int maxN=maxQue.poll();
//            maxQue.remove(minN);
//            minQue.remove(maxN);
//            res++;
//            int newN=minN+maxN-target;
//            if(newN!=target){
//                minQue.add(newN);
//                maxQue.add(newN);
//            }
//        }
//        System.out.println(res);
//    }
//}
//
////处理队列和map
////            m.merge(minN,-1,(a,b)->a+b);
////            m.merge(maxN,-1,(a,b)->a+b);
////            if(m.get(minN)==0){
////                m.remove(minN);
////                maxQue.remove(minN);
////
////            }
////            if(m.get(maxN)==0){
////                m.remove(maxN);
////                minQue.remove(maxN);
////            }