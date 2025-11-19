package beibao;

import java.util.Scanner;
//3 4
//1 3 4
//15 20 30
//完全背包
public class BeibaoWanquan {
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

        //初始化dp //与01的差异点
        for(int j=weights[0];j<bagWeight+1;j++){
            dp[0][j]=dp[0][j-weights[0]]+values[0];
        }
        for(int i=0;i<numOfItem;i++){
            dp[i][0]=0;
        }

        //for循环
        for(int i=1;i<numOfItem;i++){
            for(int j=0;j<bagWeight+1;j++){
                if(j<weights[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],values[i]+dp[i][j-weights[i]]);//与01的差异点
                }

            }
        }

        System.out.print(dp[numOfItem-1][bagWeight]);
    }
}
