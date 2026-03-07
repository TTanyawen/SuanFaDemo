package sort.sort_20260307;

import java.util.Arrays;
import java.util.Scanner;


//9
//5 2 1 7 3 4 9 0 8

// 1. 从最后一个非叶子节点开始调整
// 2. 直到最大堆建好
// 3. 确认一个元素，len-=1
public class HeapSort_mx {


    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void heapSort(int[] arr){
        int len=arr.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(arr,i,len);
        }

        for(int end=len-1;end>=1;end--){
            swap(arr,0,end);
            heapify(arr,0,end);
        }
    }
    public static void heapify(int[] arr,int index,int len){
        int left=index*2+1;
        int right=index*2+2;

        int maxI=index;
        if(left<=len-1&&arr[left]>arr[maxI]){
            maxI=left;
        }
        if(right<=len-1&&arr[right]>arr[maxI]){
            maxI=right;
        }
        if(maxI!=index){
            swap(arr,maxI,index);
            heapify(arr,maxI,len);
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
