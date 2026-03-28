//package hot100;
//
//import java.util.Arrays;
//
//public class BL_T_0314_1 {
//    public static void main(String[] args) {
//        int[] num={1,0,1,0,3,2};
//        System.out.println(Arrays.toString(rearrange_odd_even(num)));
//    }
//    public static int[] rearrange_odd_even(int[] nums) {
//        // write code here
//        int N0=0,N1=0;
//        for(int num:nums){
//            if(num%2==0){
//                N0++;
//            }else{
//                N1++;
//            }
//        }
//        if(Math.abs(N0-N1)>1){
//            return new int[]{-1};
//        }
//        int[] arr0=new int[N0];
//        int[] arr1=new int[N1];
//        int[] res=new int[N0+N1];
//
//        int i0=0;
//        int i1=0;
//        for(int num:nums){
//            if(num%2==0){
//                arr0[i0]=num;
//                i0++;
//            }else{
//                arr1[i1]=num;
//                i1++;
//            }
//        }
//        Arrays.sort(arr0);
//        Arrays.sort(arr1);
//
//        int index=0;
//        if(arr0[0]<arr1[0]){//偶数开始先
//            for(int i=0;i<=N0-1;i++){
//                res[i*2]=arr0[i];
//            }
//            for(int i=0;i<=N1-1;i++){
//                res[i*2+1]=arr1[i];
//            }
//        }else{//奇数在前
//            for(int i=0;i<=N0-1;i++){
//                res[i*2+1]=arr0[i];
//            }
//            for(int i=0;i<=N1-1;i++){
//                res[i*2]=arr1[i];
//            }
//        }
//        return res;
//
//
//    }
//}
