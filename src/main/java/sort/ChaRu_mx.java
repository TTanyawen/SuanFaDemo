package sort;

import java.util.Scanner;

//5
//5 4 3 2 1
public class ChaRu_mx {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int arr[]=new int[len];

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

        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();


    }
}
