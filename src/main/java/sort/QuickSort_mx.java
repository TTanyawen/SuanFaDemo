package sort;

import java.util.Scanner;

//9
//5 2 1 7 3 4 9 0 8
public class QuickSort_mx {

    static int len;
    static int[] arr;

    public static void init(){
        Scanner sc=new Scanner(System.in);
        len=sc.nextInt();

        arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid=partition(arr,left,right);

        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
    }

    public static int partition(int[] arr,int left,int right){
        int pivot=left;
        int index=pivot+1;

        for(int i=index;i<=arr.length-1;i++){
            if(arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }

        swap(arr,pivot,index-1);
        return index-1;

    }

    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void main(String args[]){
        init();

        quickSort(arr,0,arr.length);

        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
}
