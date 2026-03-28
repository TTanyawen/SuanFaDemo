//package hot100;
//
//import java.util.Arrays;
//
////[[0, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647],
////        [0, 2147483647, 2147483647, 2147483647, 2147483647, 1, 0, 0, 0, 0, 0],
////        [0, 2147483647, 1, 0, 0, 0, 0, 0, 0, 0, 0],
////        [0, 2147483647, 1, 0, 0, 0, 1, 0, 0, 0, 0],
////        [0, 2147483647, 1, 0, 1, 0, 1, 0, 0, 0, 0],
////        [0, 2147483647, 1, 1, 0, 0, 1, 0, 0, 0, 0]]
//public class AT3 {
//    public static void main(String[] args) {
//
//        int w=10;
//        int[] arr={5,2,6,4,3};
//        int[] res=trunkLoad(w,arr);
//        System.out.println(Arrays.toString(res));
//    }
//    public static int[] trunkLoad(int w, int[] c) {
//        int n=c.length;
//        // write code here
//        int[][] dp=new int[n+1][w+1];
//        int[][][] mark=new int[n+1][w+1][n];//记录转载的货物
//        //初始化DP
//        for(int i=0;i<=dp.length-1;i++){
//            dp[i][0]=0;
//        }
//        for(int j=1;j<=dp[0].length-1;j++){
//            dp[0][j]=Integer.MAX_VALUE;
//        }
//        for(int i=1;i<=dp.length-1;i++){
//            int index=i-1;//货物编号
//            for(int j=1;j<=dp[0].length-1;j++){
//                if(c[index]>j){
//                    dp[i][j]=dp[i-1][j];
//                    continue;
//                }
//                if(c[index]==j){
//                    dp[i][j]=1;
//                    mark[i][j][index]=1;
//                    continue;
//                }
//                if(dp[i-1][j-c[index]]!=Integer.MAX_VALUE){
//                    if(dp[i-1][j-c[index]]+1<dp[i-1][j]){
//                        //更新dp
//                        dp[i][j]=dp[i-1][j-c[index]]+1;
//                        //更新mark
//                        mark[i][j]=mark[i-1][j-c[index]];
//                        mark[i][j][index]=1;
//                    }else{
//                        dp[i][j]=dp[i-1][j];
//                        mark[i][j]=mark[i-1][j];
//                    }
//
//                }else{
//                    dp[i][j]=dp[i-1][j];
//                    mark[i][j]=mark[i-1][j];
//                }
//            }
//        }
////        System.out.println(Arrays.deepToString(dp));
//        return mark[n][w];
//
//
//    }
//}
