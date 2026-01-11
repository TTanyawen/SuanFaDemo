package sort.sort_20260111;

import java.util.Arrays;
import java.util.Scanner;

//9
//5 2 1 7 3 4 9 0 8
public class QuickSort_mx {
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int pivot=left;
        int index=pivot+1;
        for(int i=index;i<=right;i++){
            if(arr[i]<arr[pivot]){
                swap(arr,index,i);
                index++;
            }
        }
        swap(arr,index-1,pivot);
        int mid=index-1;
        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
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
