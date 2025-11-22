package sort;

import java.util.Scanner;
//9
//5 2 1 7 3 4 9 0 8
public class HeapSort {

    static int[] arr;
    static int len;

    public static void heapSort(int[] array){
        int len=array.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(array,len,i);
        }

        for(int i=len-1;i>0;i--){
            swap(array,0,i);
            heapify(array,i,0);
        }
    }
    public static void heapify(int[] array,int len,int i){
        int max=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<len&&array[left]>array[max]){
            max=left;
        }
        if(right<len&&array[right]>array[max]){
            max=right;
        }
        if(max!=i){
            swap(array,i,max);
            heapify(array,len,max);
        }

    }
    public static void swap(int[] arr, int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void main(String[] args) {
        init();
        heapSort(arr);
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
    public static void init(){
        Scanner sc=new Scanner(System.in);
        len=sc.nextInt();
        arr=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }


    }
}
