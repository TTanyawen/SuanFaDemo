//package hot100;
//
//import java.util.Scanner;
////20 10 3
////4 5
////9 2
////15 6
//
//public class T_PDD0315_02 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int L=sc.nextInt();
//        int C=sc.nextInt();
//        int N=sc.nextInt();
//        int[][] arr=new int[N][2];
//        for(int i=0;i<=N-1;i++){
//            arr[i][0]=sc.nextInt();
//            arr[i][1]=sc.nextInt();
//        }
//
//        int curCost=Integer.MAX_VALUE;
//        int curPos=0;
//        //第一轮选充电站前往
//        for(int i=0;i<=arr.length-1;i++){
//            int position=arr[i][0];
//            int cost=arr[i][1];
//            if(position<=C){
//                if(cost<curCost){
//                    curCost=cost;
//                    curPos=position;
//                }
//            }
//
//        }
//        if(curPos==0){
//            System.out.println(-1);
//            return;
//        }
//        //curPos就是第一个充电桩的位置了
//        int curC=C-curPos;
//        int money=0;
//
//        while(true){
//            if(curPos+curC>=L){
//                break;
//            }
//            //判断这一个充电桩是否要充满
//            //看position~position+C的范围内有没有更小单价的充电桩
//            int minCost=Integer.MAX_VALUE;
//            int nextPos=curPos;
//            for(int i=0;i<=arr.length-1;i++){
//                int position=arr[i][0];
//                int cost=arr[i][1];
//                if(position>curPos&&position<=curPos+C){
//                    if(cost<minCost){
//                        minCost=cost;
//                        nextPos=position;
//                    }
//                }
//            }
//            if(nextPos==curPos){//没有找到下一个充电桩
//                //判断是否能到达结尾
//                if(curPos+C>=L){
//                    //还需要充电
//                    money+=(curCost*(L-curPos-curC));
//                }else{
//                    System.out.println(-1);
//                    return;
//                }
//
//                break;
//            }
//            //算下一轮到达站点时候的curC和money
//            if(minCost<curCost){
//                //只充够到下一个站点的
//                //要充(nextPos-curPos)-curC;
//                money+=(curCost*((nextPos-curPos)-curC));
//                curC=0;
//            }else{//充满
//
//                //到下一个站点还剩下
//
//                money+=(curCost*(C-curC));
//                curC=C-(nextPos-curPos);
//            }
//
//            //更新curPos和curCost
//            curPos=nextPos;
//            curCost=minCost;
//
//        }
//        System.out.println(money);
//
//    }
//}
