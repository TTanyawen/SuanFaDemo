package sort;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;


//9
//5 2 1 7 3 4 9 0 8

// 1. 从最后一个非叶子节点开始调整
// 2. 直到最大堆建好
// 3. 确认一个元素，len-=1
public class HeapSort_mx {

    static int len;
    static int[] arr;
    public static void heapSort(int[] arr){
        int len=arr.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(arr,len,i);
        }

        for(int i=len-1;i>=1;i--){
            swap(arr,i,0);
            heapify(arr,i,0);
        }
    }
    public static void heapify(int[] arr,int len,int i){
        int max=i;
        int left=i*2+1;
        int right=i*2+2;

        if(left<=len-1&&arr[left]>arr[max]){
            max=left;
        }
        if(right<=len-1&&arr[right]>arr[max]){
            max=right;
        }

        if(max!=i){
            swap(arr,i,max);
            heapify(arr,len,max);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void init(){
        Scanner sc=new Scanner(System.in);
        len=sc.nextInt();
        arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
    }
    public static void main(String args[]){
        init();
        heapSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();

    }
}
