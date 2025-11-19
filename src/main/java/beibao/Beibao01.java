package beibao;

import java.util.*;
//input
// numOfItem bagWeight
// weights[]
// values[]

//3 4
//1 3 4
//15 20 30

// 01背包
// https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
public class Beibao01 {
    static int weights[];
    static int values[];
    static int numOfItem;
    static int bagWeight;

    static int maxValue=0;

    static int dp[][];

    //暴力解法：遍历
    public static void f(int step,int sumV,int sumW){//0,1,2
        if(step>2){
            if(sumV>maxValue){
                maxValue=sumV;
            }
            return;
        }

        //不取i=step
        f(step+1,sumV,sumW);
        //取i=step
        if(sumW+weights[step]<=bagWeight){
            f(step+1,sumV+values[step],sumW+weights[step]);
        }

    }
    public static void init(){
        Scanner scanner = new Scanner(System.in);
        numOfItem = scanner.nextInt();
        bagWeight = scanner.nextInt();
        weights=new int[numOfItem];
        values=new int[numOfItem];

        for(int i=0;i<numOfItem;i++){
            weights[i]=scanner.nextInt();
        }
        for(int i=0;i<numOfItem;i++){
            values[i]=scanner.nextInt();
        }

        dp=new int[numOfItem][bagWeight+1];


    }
    //01背包解法
    public static int f01() {

        for(int j=weights[0];j<=bagWeight;j++){
            dp[0][j]=values[0];
        }

        //for循环
        for(int i=1;i<=numOfItem-1;i++){
            for(int j=0;j<=bagWeight;j++){
                if(weights[i]<=j){
                    dp[i][j]=Math.max(values[i]+dp[i-1][j-weights[i]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[numOfItem-1][bagWeight];
    }

    public static void main(String[] args) {
//        f(0,0,0);
        init();
        maxValue=f01();
        System.out.println(maxValue);

    }
}
