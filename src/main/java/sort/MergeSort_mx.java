package sort;

import java.util.Arrays;
import java.util.Scanner;

//9
//5 2 1 7 3 4 9 0 8
public class MergeSort_mx {
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

    public static int[] mergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }

        int[] left=Arrays.copyOfRange(arr,0,arr.length/2);
        int[] right=Arrays.copyOfRange(arr,arr.length/2,arr.length);

        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] arr1,int[] arr2){
        int[] res=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<=arr1.length-1&&j<=arr2.length-1){
            if(arr1[i]<arr2[j]){
                res[k]=arr1[i];
                i++;
            }else{
                res[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<=arr1.length-1){
            res[k]=arr1[i];
            k++;
            i++;
        }
        while(j<=arr2.length-1){
            res[k]=arr2[j];
            k++;
            j++;
        }
        return res;
    }


    public static void main(String args[]){
        init();

        int[] res=mergeSort(arr);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }System.out.println();
    }
}
