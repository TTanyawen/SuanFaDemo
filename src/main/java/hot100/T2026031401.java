//package hot100;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class T2026031401 {
//    public static void main(String[] args) {
//        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trap(height));
//    }
//    public static int trap(int[] height) {
//        // int[] H=new int[height.length+2];
//
//        // for(int i=0;i<=height.length-1;i++){
//        //     H[i+1]=height[i];
//        // }
//        int res=0;
//        //单调非严格递减
//        Deque<Integer> que=new LinkedList<>();//放index
//        for(int i=0;i<=height.length-1;i++){
//            if(que.isEmpty()) {
//                que.offerLast(i);
//                continue;
//            }
//            if(height[i]<=height[que.peekLast()]){
//                que.offerLast(i);
//                continue;
//            }
//
//            //大于的情况
//
//            while(!que.isEmpty()&&height[i]>height[que.peekLast()]){
//                int index=que.pollLast();
//                if(que.isEmpty()){
//                    break;
//                }
//                int space=(Math.min(height[i],height[que.peekLast()])-height[index])*(i-que.peekLast()-1);
//                res+=(space>0?space:0);
//            }
//            que.offerLast(i);
//        }
//        return res;
//    }
//}
