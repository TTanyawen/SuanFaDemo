package sort;

import java.util.Scanner;
//9
//9 8 7 6 5 4 3 2 1

public class XiEr_mx {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        for(int gap=len/2;gap>0;gap/=2){
            for(int i=gap;i<=len-1;i++){
                int key=arr[i];
                int j=i-gap;

                while(j>=0&&arr[j]>key){
                    arr[j+gap]=arr[j];
                    j-=gap;
                }

                arr[j+gap]=key;
            }

        }

        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();


    }
}
