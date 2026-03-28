//package hot100;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class BL_T_0314_2 {
//    public static void main(String[] args) {
//        int[] nums={1,2,-2,-1};
//        System.out.println(is_perfect_seal(nums));
//    }
//    public static boolean is_perfect_seal(int[] nums) {
//        // write code here
//        //stack
//        Deque<Integer> stk=new LinkedList<>();
//        for(int num:nums){
//            if(num>0){
//                stk.offerLast(num);
//            }else{
//                if(!stk.isEmpty()&&stk.peekLast()==(-num)){
//                    stk.pollLast();
//                }else{
//                    return false;
//                }
//            }
//        }
//        return stk.isEmpty();
//    }
//}
