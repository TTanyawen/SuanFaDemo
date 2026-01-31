package sort.sort_20260131;

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
        int len=arr.length;
        int[] left=Arrays.copyOfRange(arr,0,len/2);
        int[] right=Arrays.copyOfRange(arr,len/2,len);
        return merge(mergeSort(left),mergeSort(right));
    }
    public static int[] merge(int[] arr1,int[] arr2){
        int len1=arr1.length;
        int len2=arr2.length;
        int i=0;
        int j=0;
        int k=0;
        int[] res=new int[len1+len2];
        while(i<=len1-1&&j<=len2-1){
            if(arr1[i]<arr2[j]){
                res[k]=arr1[i];
                i++;
            }else{
                res[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<=len1-1){
            res[k]=arr1[i];
            i++;
            k++;
        }
        while(j<=len2-1){
            res[k]=arr2[j];
            j++;
            k++;
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
