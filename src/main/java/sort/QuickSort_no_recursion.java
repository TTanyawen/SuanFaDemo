package sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//9
//5 2 1 7 3 4 9 0 8

//快排优化->改成不递归的，用栈来维护区间
public class QuickSort_no_recursion {
    public static void quickSort(int[] arr){
        Stack<int[]> stack = new Stack<>();

        // 初始区间入栈
        stack.push(new int[]{0, arr.length - 1});
        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int from = range[0];
            int to = range[1];

            if (from >= to) continue;

            int mid = partition(arr, from, to);
            //新的两个区间入栈，先处理小区间减少栈的深度
            if (mid - 1 - from > to - (mid + 1)) {
                stack.push(new int[]{from, mid - 1});
                stack.push(new int[]{mid + 1, to});
            } else {
                stack.push(new int[]{mid + 1, to});
                stack.push(new int[]{from, mid - 1});
            }
        }
    }

    public static int partition(int[] arr,int from,int to){
        int pivot=from;
        int index=pivot+1;
        for(int i=index;i<=to;i++){
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        int mid=index-1;
        swap(arr,mid,pivot);
        return mid;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
