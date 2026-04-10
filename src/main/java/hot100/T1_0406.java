package hot100;

import java.util.*;

/*
3
2 1 -1

3
2 1 21

3
-2 -1 -21

4
10 100 1000 1
 */
public class T1_0406 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=n-1;i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<0&&o2>0){
                    return -1;
                }
                String a=o1.toString()+o2.toString();
                String b=o2.toString()+o1.toString();
                if(a.compareTo(b)<0){
                    return -1;
                }else if(a.compareTo(b)>0){
                    return 1;
                }else{
                    return 0;
                }
//                int i1=o1;
//                int i2=o2;
//                int cnt1=1;
//                int cnt2=1;
//                while(i1!=0){
//                    i1/=10;
//                    cnt1*=10;
//                }
//                while(i2!=0){
//                    i2/=10;
//                    cnt2*=10;
//                }
////                System.out.println(o1+","+o2+","+cnt1+","+cnt2);
//                if(o1*cnt2+o2>o2*cnt1+o1){
//                    return 1;
//                }else if(o1*cnt2+o2<o2*cnt1+o1){
//                    return -1;
//                }
//                return 0;
            }
        });
        for(int num:list){
            System.out.print(num+" ");
        }
    }
}
