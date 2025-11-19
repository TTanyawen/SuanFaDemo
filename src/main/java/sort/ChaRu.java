package sort;

import java.util.Scanner;

//5
//5 4 3 2 1
public class ChaRu {

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

        for(int i=1;i<=len-1;i++){
            for(int j=i;j>=1;j--){
                if(arr[j]<arr[j-1]){
                    //swap
                    int tmp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tmp;
                }else{
                    break;
                }
            }
        }
        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
}
