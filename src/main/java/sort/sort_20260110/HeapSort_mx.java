package sort.sort_20260110;

import java.util.Arrays;
import java.util.Scanner;


//9
//5 2 1 7 3 4 9 0 8

// 1. 从最后一个非叶子节点开始调整
// 2. 直到最大堆建好
// 3. 确认一个元素，len-=1
public class HeapSort_mx {
    public static void heapSort(int[] arr){
        int len=arr.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(arr,i,len);
        }
        for(int i=len-1;i>=1;i--){
            swap(arr,i,0);
            heapify(arr,0,i);
        }
    }
    public static void heapify(int[] arr,int i,int len){
        int maxIndex=i;
        int left=i*2+1;
        int right=i*2+2;

        if(left<=len-1&&arr[left]>arr[maxIndex]){
            maxIndex=left;
        }
        if(right<=len-1&&arr[right]>arr[maxIndex]){
            maxIndex=right;
        }
        if(maxIndex!=i){
            swap(arr,maxIndex,i);
            heapify(arr,maxIndex,len);
        }

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

        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
