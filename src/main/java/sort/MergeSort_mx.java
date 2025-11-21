package sort;

import java.util.Arrays;
import java.util.Scanner;

//9
//5 2 1 7 3 4 9 0 8
public class MergeSort_mx {
    static int len;
    static int[] arr;

    public static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }

        int[] left=Arrays.copyOfRange(arr,0,arr.length/2);
        int[] right=Arrays.copyOfRange(arr,arr.length/2,arr.length);

        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] left,int[] right){
        int[] res=new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;

        while(i<=left.length-1&&j<=right.length-1){
            if(left[i]<right[j]){
                res[k]=left[i];
                i++;
            }else{
                res[k]=right[j];
                j++;
            }
            k++;

        }
        while(i<=left.length-1){
            res[k]=left[i];
            k++;
            i++;
        }
        while(j<=right.length-1){
            res[k]=right[j];
            k++;
            j++;
        }

        return res;
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
        int[] res=mergeSort(arr);

        for(int i=0;i<=res.length-1;i++){
            System.out.print(res[i]+" ");
        }System.out.println();
    }
}
