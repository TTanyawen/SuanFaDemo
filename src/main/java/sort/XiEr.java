package sort;

import java.util.Scanner;
//9
//9 8 7 6 5 4 3 2 1

public class XiEr {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int arr[]=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }

        // 初始 gap
        for (int gap = len / 2; gap > 0; gap /= 2) {
            // 对每个 gap 做分组插入排序(这里不是一组组来的，是按照顺序遍历[gap,len-1],对当下key插入到它所属组的某个位置)
            for (int i = gap; i < len; i++) {

                int key = arr[i];
                int j = i - gap;

                // 组内插入排序：保证 j >= 0 即可，不会跨组
                while (j >= 0 && arr[j] > key) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = key;
            }
            for(int i=0;i<len;i++){
                System.out.print(arr[i]+" ");
            }System.out.println();
        }



        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();
    }
}
