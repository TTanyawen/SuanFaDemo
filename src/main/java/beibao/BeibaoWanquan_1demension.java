package beibao;

import java.util.Scanner;

//3 4
//1 3 4
//15 20 30
//完全背包
public class BeibaoWanquan_1demension {
    static int numOfItem;
    static int bagWeight;
    static int[] weights;
    static int[] values;

    static int[] dp;

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
        dp=new int[bagWeight+1];


    }
    public static void main(String[] args){
        init();
        //for循环
        for(int i=0;i<numOfItem;i++){//从0开始，因为不像2维需要对i=0赋初值了
            for(int j=weights[i];j<bagWeight+1;j++){//不需要避免重复取
                dp[j]=Math.max(dp[j],values[i]+dp[j-weights[i]]);
            }
        }

        System.out.print(dp[bagWeight]);
    }
}
