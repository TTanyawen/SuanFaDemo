package sort;

import java.util.Arrays;
import java.util.Scanner;
//9
//5 2 1 7 3 4 9 0 8
public class MergeSort {
    static int[] arr;
    static int len;
    public static int[] mergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int[] left= Arrays.copyOfRange(arr,0,arr.length/2);
        int[] right= Arrays.copyOfRange(arr,arr.length/2,arr.length);

        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] arr0,int[] arr1){
        int [] resArr=new int[arr0.length+arr1.length];

        int i0=0;
        int i1=0;
        int ir=0;

        while(i0<=arr0.length-1&&i1<=arr1.length-1){
            if(arr0[i0]<arr1[i1]){
                resArr[ir]=arr0[i0];
                i0++;
            }else{
                resArr[ir]=arr1[i1];
                i1++;
            }
            ir++;

        }
        while(i0<=arr0.length-1){
            resArr[ir]=arr0[i0];
            i0++;
            ir++;
        }
        while(i1<=arr1.length-1){
            resArr[ir]=arr1[i1];
            i1++;
            ir++;
        }

        return resArr;
    }
    public static void init(){
        Scanner sc=new Scanner(System.in);
        len=sc.nextInt();
        arr=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
    }
    public static void main(String[] args) {
        init();

        int[] res=mergeSort(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
