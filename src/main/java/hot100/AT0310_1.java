//package hot100;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///*
//2
//kyoto
//tokyo
//aba
//aab
// */
//public class AT0310_1 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        String[][] arr=new String[n][2];
//        for(int i=0;i<n;i++){
//            arr[i][0]=sc.next();
//            arr[i][1]=sc.next();
//        }
////        System.out.println(Arrays.deepToString(arr));
//        f(n,arr);
//    }
//    public static void f(int n, String[][] arr){
//        for(int i=0;i<n;i++){
//            String s=arr[i][0];
//            String t=arr[i][1];
//            boolean flag=false;
//            for(int j=0;j<s.length();j++){
//                s=reverse(s);
//                if(s.equals(t)){
//                    System.out.println("Yes");
//                    flag=true;
//                    break;
//                }
//            }
//            if(!flag){
//                System.out.println("No");
//            }
//        }
//    }
//    public static String reverse(String str){
//        char[] chars=str.toCharArray();
//        char tmp=chars[0];
//        for(int i=0;i<=chars.length-2;i++){
//            chars[i]=chars[i+1];
//        }
//        chars[chars.length-1]=tmp;
////        System.out.println(new String(chars));
//        return new String(chars);
//    }
//}
