package sort.sort_20260307;

import java.util.Scanner;
//9
//9 8 7 6 5 4 3 2 1

public class XiEr_mx {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        for(int gap=len/2;gap>=1;gap/=2){
            for(int i=gap;i<=len-1;i++){
                int index=i-gap;
                int tmp=arr[i];
                while(index>=0&&arr[index]>tmp){
                    arr[index+gap]=arr[index];
                    index-=gap;
                }
                arr[index+gap]=tmp;
            }
        }


        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
}
