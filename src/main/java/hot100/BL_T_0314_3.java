//package hot100;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class BL_T_0314_3 {
//    public static void main(String[] args) {
//        int m=2;
//        int[] nums={2,3,4};
//        System.out.println(min_operation(m,nums));
//    }
//    public static void run(int[] nums,int[] dp,int step,int remains,int sum){
//        if(step>=nums.length){
//            dp[sum]=nums.length-remains;
//            return;
//        }
//        //取
//        run(nums,dp,step+1,remains+1,sum+nums[step]);
//        //不取
//        run(nums,dp,step+1,remains,sum);
//    }
//    public static int min_operation(int m, int[] nums) {
//        // write code here
//        int sum=0;
//        for(int num:nums){
//            sum+=num;
//        }
//        if(sum<m){
//            return m-sum;
//        }
//        if(sum%m==0){
//            return 0;
//        }
//        //入set
//        int res=nums.length;
//        int[] dp=new int[sum+1];
//        dp[sum]=0;
//        for(int num:nums){
//            dp[sum-num]=1;
//        }
//        int index=0;
////        //减去一个
////        for(int i=0;i<dp.length;i++){
////            if(dp[i]==1){
////                index=i;
////                break;
////            }
////        }
////        //减去2个
//        run(nums,dp,0,0,0);
//
//        //算剩下的部分剪掉一个的
//        for(int i=1;i<dp.length-1;i++){
//            if(dp[i]==0){
//                dp[i]=dp[i-1]+1;
//            }
//        }
//
//        for(int i=1;i<dp.length-1;i++){
//            if(i%m==0){
//                res=Math.min(res,dp[i]);
//            }
//        }
//        return res;
//
//    }
//
//}
