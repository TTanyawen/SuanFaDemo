package sort;

import java.util.Arrays;
import java.util.Scanner;
//9
//5 2 1 7 3 4 9 0 8

//快排优化->pivot三个数取中间值使其更加随机
public class QuickSort_random_pivot {
    public static void quickSort(int[] arr,int from,int to){
        if(from>=to){
            return;
        }
        int mid=partition(arr,from,to);

        quickSort(arr,from,mid-1);
        quickSort(arr,mid+1,to);
    }

    public static int partition(int[] arr,int from,int to){
        //首尾中，取一个中间元素作为pivot
        int a=from;
        int b=(from+to)/2;
        int c=to;
        if (arr[a] > arr[b]) swap(arr, a, b);
        if (arr[a] > arr[c]) swap(arr, a, c);
        if (arr[b] > arr[c]) swap(arr, b, c);
        swap(arr, from, b);


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
        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
