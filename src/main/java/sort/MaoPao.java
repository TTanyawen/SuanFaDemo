package sort;

import java.util.Scanner;

//5
//5 4 3 2 1
public class MaoPao {

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
        for(int i=0;i<len-1;i++){
            for(int j=1;j<=len-1;j++){
                if(arr[j]<arr[j-1]){
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }
            }
        }


        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
}
