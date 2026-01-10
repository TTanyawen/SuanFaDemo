package sort.sort_20260110;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

//5
//5 4 3 2 1

//10
//6 7 4 5 9 2 8 1 3 0
public class XuanZe_mx {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<=len-2;i++){
            int pos=i;
            for(int j=i+1;j<=len-1;j++){
                if(arr[j]<arr[pos]){
                    pos=j;
                }
            }
            int tmp=arr[i];
            arr[i]=arr[pos];
            arr[pos]=tmp;

        }
        System.out.println(Arrays.toString(arr));

    }

}
