package sort.sort_20260307;

import java.util.Scanner;

//5
//5 4 3 2 1
public class ChaRu_mx {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<=len-1;i++){
            int index=i-1;
            int num=arr[i];
            while(index>=0&&arr[index]>num){
                arr[index+1]=arr[index];
                index--;
            }

            arr[index+1]=num;
        }

        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();


    }
}
