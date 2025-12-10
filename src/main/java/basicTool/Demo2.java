package basicTool;

import java.util.*;

//对int[]做去重和排序
public class Demo2 {
    public static void main(String[] args) {
        int[] nums={2,2,3,6,5,1,4};

        int[] res=Arrays.stream(nums).distinct().sorted().toArray();
        for(int i:res){
            System.out.print(i+" ");
        }

        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);

        for(int i:l){
            System.out.println(i);
        }


    }
}
