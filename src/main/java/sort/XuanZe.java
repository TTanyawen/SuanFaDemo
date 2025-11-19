package sort;

import java.util.Scanner;

//5
//5 4 3 2 1
public class XuanZe {

    static int len;
    static int arr[];

    public static void init(){
        Scanner sc=new Scanner(System.in);
        len=sc.nextInt();
        arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

    }
    public static void main(String[] args) {
        init();

        int minI;
        for(int i=0;i<=len-2;i++){
            minI=i;
            for(int j=i+1;j<=len-1;j++){
                if(arr[j]<arr[minI]){
                    minI=j;
                }
            }

            //swap
            int tmp=arr[i];
            arr[i]=arr[minI];
            arr[minI]=tmp;


        }


        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
}
