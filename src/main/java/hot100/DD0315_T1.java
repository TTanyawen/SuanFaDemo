//package hot100;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
////6 2
////0 0 1 1 2 2
//public class DD0315_T1 {
//    int min=Integer.MIN_VALUE;
//
//    public static void run(int[] arr,int step,int pre){
////        if(step>k){
////
////        }
//        for(int i=pre+1;i<=arr.length-1;i++){
////            run(arr,)
//        }
//    }
//    public static int[] getPartitionMaxMin(int[] arr,int from,int to){
//        //遍历切分位置pos
//
//        int res=Integer.MIN_VALUE;
//        int resPos=from;
//        for(int pos=from+1;pos<=to;pos++){
//            int getleft=get(arr,from,pos-1);
//            int getright=get(arr,pos,to);
//            int a=Math.min(getleft,getright);
//            if(a>res){
//                res=a;
//                resPos=pos;
//            }
//
//        }
//        return new int[]{res,resPos};
//    }
//    public static int get(int[] arr,int from,int to){
//        int[] tmp= Arrays.copyOf(arr,arr.length);
//        Arrays.sort(tmp);
//        int a=tmp[from];
//        if(a!=0){
//            return 0;
//        }
//        for(int i=from;i<=to;i++){
//            if(arr[i]==a||arr[i]==a+1){//合法的
//                a=arr[i];
//            }else{
//                return a+1;
//            }
//        }
//        return a+1;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int k=sc.nextInt();
//        int[] arr=new int[n];
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<=n-1;i++){
//            arr[i]=sc.nextInt();
//            min=Math.min(min,arr[i]);
//        }
//        Set<Integer> set=new HashSet<>();
//        //没有0,一定是0
//        if(min!=0){
//            System.out.println(0);
//            return;
//        }
//
//        //k=1
//        if(k==1){
//            for(int num:arr){
//                set.add(num);
//            }
//            int i=min;
//            while(true){
//                if(!set.contains(i)){
//                    System.out.println(i);
//                    return;
//                }else{
//                    i++;
//                }
//            }
//        }
//
//
//        if(k==2){
//
//            int res=getPartitionMaxMin(arr,0,arr.length-1)[0];
//            System.out.println(res);
//            return;
//        }
//    }
//}
