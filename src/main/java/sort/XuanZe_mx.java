package sort;

import java.util.Scanner;

//5
//5 4 3 2 1
public class XuanZe_mx {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int arr[]=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }


        for(int i=0;i<=len-2;i++){
            int minIndex=i;
            for(int j=i+1;j<=len-1;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }

            int tmp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=tmp;
        }

        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();


    }

}
