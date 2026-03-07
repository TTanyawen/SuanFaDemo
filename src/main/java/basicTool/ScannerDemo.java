package basicTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sc.nextInt();//读一个整数
        sc.next();//读一个字符串，空格为分割
        sc.next();//读一行，空格也包括在内


        //读N个int
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<=n-1;i++){
            arr[i]=sc.nextInt();
        }

        //不清楚有多少行
        List<Integer> l=new ArrayList<>();
        while(sc.hasNext()){
            l.add(sc.nextInt());
        }

        //读一行，然后拆分
        String line=sc.nextLine();
        String[] strArr=line.split(" ");
        for(String s:strArr){
            int num=Integer.parseInt(s);
        }

    }
}
