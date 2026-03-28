package hot100;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/*
拼成最大数
`[3, 30, 34, 5, 9]`->`9534330`
 */
public class T202603080002 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={3,30,34,5,9};
        TreeSet<Integer> ts=new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1.toString()+o2.toString();
                String s2=o2.toString()+o1.toString();
                int i1=Integer.parseInt(s1);
                int i2=Integer.parseInt(s2);
                if(i1>i2){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
//        ts.addAll(List.of(3,30,34,5,9));
        StringBuilder sb=new StringBuilder();
        for(int i:ts){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
