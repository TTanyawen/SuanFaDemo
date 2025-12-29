//package hot100;
// 错误的，忽略
//public class T33 {
//    public static void main(String[] args) {
////        int[] nums=new int[]{4,5,6,7,0,1,2};
////        int target=0;
////        Solution solution=new Solution();
////        int i = solution.search(nums, target);
////        System.out.println(i);
//
////        int[] nums=new int[]{1};
////        int target=0;
////        Solution solution=new Solution();
////        int i = solution.search(nums, target);
////        System.out.println(i);
//
//        int[] nums=new int[]{1,3};
//        int target=0;
//        Solution solution=new Solution();
//        int i = solution.search(nums, target);
//        System.out.println(i);
//    }
//
//}
//class Solution {
//    public int search(int[] nums, int target) {
//        if(nums.length==0){
//            return -1;
//        }
//        if(nums.length==1){
//            return nums[0]==target?0:-1;
//        }
//        int len=nums.length;
//        int left=0;
//        int right=len-1;
//        int k=0;
//        //确定left和right
//        if(nums[0]<nums[len-1]){
//            left=0;
//            right=len-1;
//        }else{
//            for(int i=0;i<=nums.length-2;i++){
//                if(nums[i]>nums[i+1]){
//                    left=i+1;
//                    right=i;
//                    break;
//                }
//            }
//        }
//        k=left;
//
//        while(((left-k+len)%len)<=(right+k-1)%len){
//            int ori_mid=(((left-k+len)%len)+(right+k-1)%len)/2;
//            int mid=(ori_mid+k)%len;
//            if(left==right){
//                return nums[mid]==target?mid:-1;
//            }else if(target==nums[mid]){
//                return mid;
//            }else if(target<nums[mid]){
//                right=ori_mid-1<0?ori_mid-1:(ori_mid+k)%len;
//            }else{
//                left=(mid+1+len)%len;
//            }
//        }
//        return nums[left]==target?left:-1;
//
//
//
//    }
//}