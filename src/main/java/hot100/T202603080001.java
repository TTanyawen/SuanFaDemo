package hot100;

import java.util.Scanner;

/*
Shopee is Our Family 123
Seepoh si Oru Fylima 123
仅仅反转字符串

 */
public class T202603080001 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] chars=s.toCharArray();
        int end=s.length()-1;
        while(end>=0){
            //找第一个非空格
            while(end>=0&&chars[end]==' '){
                end--;
            }
            int start=end;
            while(start>=0&&chars[start]!=' '){
                start--;
            }

            //反转
            reverse(chars,start+1,end);
            end=start-1;

        }
        System.out.println(new String(chars));
    }
    public static void reverse(char[] chars, int from, int to){
        int left=from;
        int right=to;
        while(left<right){
            while(left<right&&!(chars[left]>=97&&chars[left]<=122)){
                left++;
            }
            while(left<right&&!(chars[right]>=97&&chars[right]<=122)){
                right--;
            }
            if(left<right){
                char tmp=chars[left];
                chars[left]=chars[right];
                chars[right]=tmp;
                left++;
                right--;
            }
        }
    }
}
