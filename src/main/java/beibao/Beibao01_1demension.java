package beibao;

import java.util.Scanner;
//input
// numOfItem bagWeight
// weights[]
// values[]

//3 4
//1 3 4
//15 20 30

// 01背包
// https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
public class Beibao01_1demension {
    static int weights[];
    static int values[];
    static int numOfItem;
    static int bagWeight;

    static int maxValue=0;

    static int dp[];
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

        dp=new int[bagWeight+1];

    }

    public static void main(String[] args) {
        init();
        //for循环
        for(int i=0;i<numOfItem;i++){
            for(int j=bagWeight;j>=weights[i];j--){//防止重复取
                dp[j]=Math.max(values[i]+dp[j-weights[i]],dp[j]);
            }
        }

        System.out.println(dp[bagWeight]);

    }
}
