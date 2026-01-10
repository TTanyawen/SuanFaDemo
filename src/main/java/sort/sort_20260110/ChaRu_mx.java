package sort.sort_20260110;

import java.util.Arrays;
import java.util.Scanner;

//5
//5 4 3 2 1

//10
//6 7 4 5 9 2 8 1 3 0
public class ChaRu_mx {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=1;i<=len-1;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        System.out.println(Arrays.toString(arr));
    }
}
