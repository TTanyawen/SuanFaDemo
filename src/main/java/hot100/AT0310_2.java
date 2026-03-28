//package hot100;
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
///*
//3 50
//50 105 200
// */
//public class AT0310_2 {
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        long x=sc.nextLong();
//        sc.nextLine();
//
//        long[] arr=new long[n];
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//        }
//
//        for(int i=0;i<n;i++){
//            long a=arr[i];
//            if(x>=a){
//               x+=a;
//            }else{
//                x+=get2(a,x);
//            }
//        }
//        System.out.println(x);
//
////        System.out.println(get(23*17,21*17));
//    }
//    //求最大公约数
//    public static long get(long a, long x){
//        long top= x/2;
//        long res=1;
//        for(long i=1;i<=top;i++){
//            if(a%i==0&&x%i==0){
//                res=Math.max(res,i);
//            }
//        }
//        return res;
//    }
//    public static long get2(long a, long x){
//        Set<Long> setA=new HashSet<>();
//        Set<Long> setX=new HashSet<>();
//        //向求a，再求x
//        for(long i=1;i<=Math.pow(a,0.5)+1;i++){
//            if(a%i==0){
//                setA.add(a/i);
//                setA.add(i);
//            }
//        }
//        for(long i=1;i<=Math.pow(x,0.5)+1;i++){
//            if(x%i==0){
//                setX.add(x/i);
//                setX.add(i);
//            }
//        }
//        long res=1;
//        for(long Kx:setX){
//            if(setA.contains(Kx)){
//                res=Math.max(res,Kx);
//            }
//        }
//        return res;
//    }
//}
