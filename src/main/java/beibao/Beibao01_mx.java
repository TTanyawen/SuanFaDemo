package beibao;

import java.util.*;
//3 4
//1 3 4
//15 20 30
class Beibao01_mx{
    static int numOfItem;
    static int bagWeight;
    static int[] weights;
    static int[] values;

    static int[][] dp;

    public static void init(){
        Scanner sc=new Scanner(System.in);

        numOfItem=sc.nextInt();
        bagWeight=sc.nextInt();

        weights=new int[numOfItem];
        values=new int[numOfItem];

        for(int i=0;i<numOfItem;i++){
            weights[i]=sc.nextInt();
        }
        for(int i=0;i<numOfItem;i++){
            values[i]=sc.nextInt();
        }
        dp=new int[numOfItem][bagWeight+1];


    }
    public static void main(String[] args){
        init();

        //初始化dp
        for(int j=0;j<bagWeight+1;j++){
            if(j>=weights[0]){
                dp[0][j]=values[0];
            }else{
                dp[0][j]=0;
            }
        }

        //for循环
        for(int i=1;i<numOfItem;i++){
            for(int j=0;j<bagWeight+1;j++){
                if(j<weights[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],values[i]+dp[i-1][j-weights[i]]);
                }

            }
        }

        System.out.print(dp[numOfItem-1][bagWeight]);
    }

}
