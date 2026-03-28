//package hot100;
//
//import java.util.Arrays;
//
//public class AQY_1 {
//    public static void main(String[] args) {
//        int[] nums1={1,2,3,0,0,0};
//        int m=3;
//        int[] nums2={2,5,6};
//
//        int lens1=nums1.length;
//        int lens2=nums2.length;
//
//        int indexs1=m-1;
//        int cur=lens1-1;
//        int i=lens2-1;
//
//        while(i>=0){
//            if(nums2[i]>=nums1[indexs1]){
//                nums1[cur]=nums2[i];
//                cur--;
//                i--;
//            }else{
//                nums1[cur]=nums1[indexs1];
//                indexs1--;
//                cur--;
//            }
//        }
//        System.out.println(Arrays.toString(nums1));
//    }
//}
