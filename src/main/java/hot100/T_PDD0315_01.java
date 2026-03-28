//package hot100;
//
//import java.util.*;
//
///*
//5 4
//1 100 20 5
//2 100 20 3
//1 120 10 8
//3 100 25 4
//2 110 18 6
//1
//2
//3
//5
//
//
//5 5
//1 100 10 5
//2 100 20 3
//1 100 10 8
//3 100 10 5
//2 110 18 6
//1
//2
//3
//4
//5
//
//1 1
//1 100 10 5
//1
//
// */
//public class T_PDD0315_01 {
//    static class MyNode{
//        int qN;
//        int id;
//        int a1;
//        int a2;
//        int a3;
//        MyNode(int qN,int id,int a1,int a2,int a3){
//            this.qN=qN;
//            this.id=id;
//            this.a1=a1;
//            this.a2=a2;
//            this.a3=a3;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int q=sc.nextInt();
//        MyNode[] arr=new MyNode[n];
//        int[] qarr=new int[q];
//        for(int i=0;i<=n-1;i++){
//            MyNode myNode=new MyNode(i+1,sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
//            arr[i]=myNode;
//        }
//        for(int i=0;i<=q-1;i++){
//            qarr[i]=sc.nextInt();
//        }
//
//        PriorityQueue<MyNode> que=new PriorityQueue<>(new Comparator<MyNode>() {
//            @Override
//            public int compare(MyNode o1, MyNode o2) {
//                if(o1.a1!=o2.a1){//赞DESC
//                    return o2.a1-o1.a1;
//                }
//                if(o1.a2!=o2.a2){//评论DESC
//                    return o2.a2-o1.a2;
//                }
//                if(o1.a3!=o2.a3){//时间ASC
//                    return o1.a3-o2.a3;
//                }
//                return o1.id-o2.id;//id ASC
//            }
//        });
//
//        for(MyNode ele:arr){
//            que.offer(ele);
//        }
//        Map<Integer,Integer> res=new HashMap<>();//qN,rank
//        Set<Integer> set=new HashSet<>();//id
//        int rank=1;
//        while(!que.isEmpty()){
//            MyNode myNode=que.poll();
//            if(set.contains(myNode.id)){//已经存在，存入0
//                res.put(myNode.qN,0);
//
//            }else{
//                res.put(myNode.qN,rank);
//                set.add(myNode.id);
//                rank++;
//            }
//
//        }
//        for(int qN:qarr){
//            System.out.println(res.get(qN));
//        }
//
//
//    }
//}
