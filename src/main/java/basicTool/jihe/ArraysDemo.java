package basicTool.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        //注意这样写你得到的是一个长度固定的list，不能add和remove，不推荐，除非你只是返回一个答案
        List<Integer> l1= Arrays.asList(1,2,3,4,5);

        //推荐这样写，如果你想操作list的话
        List<Integer> l2= new ArrayList<>(Arrays.asList(1,2,3,4,5));

        //排序
        int[] arr={8,4,0,3};
        Arrays.sort(arr);

        int[][] arr2={{1,2},{4,5},{0,3}};
        Arrays.sort(arr2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(arr2));

        //数组填充
        int[] arr3=new int[5];
        Arrays.fill(arr3,-1);
        System.out.println(Arrays.toString(arr3));

        //将一个数组的部分复制到另一个数组
        int[] arr4={1,2,3,4,5,6};
        int[] arr5=Arrays.copyOf(arr4,3);//复制前3个
        System.out.println(Arrays.toString(arr5));
        arr5=Arrays.copyOfRange(arr4,2,5);//index=[2,5),即index=2,3,4
        System.out.println(Arrays.toString(arr5));

        //比较两个数组
        int[] arr6={1,2,3};
        int[] arr7={1,2,3};
        System.out.println(Arrays.equals(arr6,arr7));

        int[][] arr8={{1,2},{2,3}};
        int[][] arr9={{1,2},{2,3}};
        System.out.println(Arrays.deepEquals(arr8,arr9));

        //二分查找(前提是排序好了的数组)
        int[] arr10={1,2,3,4,5,6};
        System.out.println(Arrays.binarySearch(arr10,2));
        System.out.println(Arrays.binarySearch(arr10,7));//找不到返回 -key

        //得到固定/可变长度的涵盖某些值的list
        List<Integer> l3=Arrays.asList(1,2,3);
        List<Integer> l4=new ArrayList<>(Arrays.asList(1,2,3));




    }
}
