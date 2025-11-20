package sort;

import java.util.Scanner;

//5
//5 4 3 2 1

//10
//6 7 4 5 9 2 8 1 3 0
public class MaoPao_mx {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int arr[]=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }


        for(int i=0;i<len-1;i++){
            for(int j=0;j<=len-2-i;j++){
                int tmp;
                if(arr[j]>arr[j+1]){
                    tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }

        }

        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();


    }
}
