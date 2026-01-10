package sort.sort_20260110;

import java.util.Arrays;
import java.util.Scanner;

//5
//5 4 3 2 1

//10
//6 7 4 5 9 2 8 1 3 0

//注意冒泡每次确定的元素是在后面的
public class MaoPao_mx {
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       int len=sc.nextInt();
       int arr[]=new int[len];
       for(int i=0;i<len;i++){
           arr[i]=sc.nextInt();
       }
       for(int i=0;i<=len-2;i++){
           for(int j=0;j<=len-2-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
           }
       }

       System.out.println(Arrays.toString(arr));

    }
}
