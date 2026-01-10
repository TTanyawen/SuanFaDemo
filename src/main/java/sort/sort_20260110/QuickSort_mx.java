package sort.sort_20260110;

import java.util.Arrays;
import java.util.Scanner;

//9
//5 2 1 7 3 4 9 0 8
public class QuickSort_mx {
    public static void quickSort(int[] arr,int from,int to){
        if(from>=to){
            return;
        }
        int len=arr.length;
        int pivot=from;
        int index=pivot+1;

        for(int i=index;i<=to;i++){
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        int mid=index-1;
        swap(arr,pivot,index-1);
        quickSort(arr,from,mid-1);
        quickSort(arr,mid+1,to);


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
