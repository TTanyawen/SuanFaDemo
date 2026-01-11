package sort.sort_20260111;

import java.util.Arrays;
import java.util.Scanner;

public class XiEr_mx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        for(int gap=len/2;gap>=1;gap/=2){
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
        System.out.println(Arrays.toString(arr));
    }
}
