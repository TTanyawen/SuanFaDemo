package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class T15 {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0,0,0};
        threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        // 1. 排序
        Arrays.sort(nums);
        for(int i=0;i<=len-3;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<=len-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int target=0-nums[i]-nums[j];
                for(int k=j+1;k<=len-1;k++){
                    if(nums[k]==target){
                        List<Integer> ele=new ArrayList<>();
                        ele.add(nums[i]);
                        ele.add(nums[j]);
                        ele.add(nums[k]);
                        res.add(ele);
                        break;
                    }
                }
            }
        }
        return res;
    }
}