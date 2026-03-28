//package hot100;
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
///*
//3
//12
//1
//60
// */
//public class AT0310_3 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        sc.nextLine();
//        long[] arr=new long[n];
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextLong();
//            sc.nextLine();
//        }
//        for(long num:arr){
//            System.out.println(count(num));
//        }
//    }
//    public static int count(long x){
//        Set<Long> set=new HashSet<>();
//        for(long i=1;i<=Math.pow(x,0.5)+1;i++){
//            if (x%i==0){
//                set.add(i);
//            }
//        }
//
//        int res=0;
//        for(long num:set){
//            if(set.contains(num+1)){
//                res++;
//            }
//        }
//        return res;
//
//    }
//}
