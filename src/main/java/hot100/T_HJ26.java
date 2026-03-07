package hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class T_HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();

        char[] chars=str.toCharArray();
        int len=chars.length;
        //0：对应的小写的ascll码，1：出现顺序(index)
        TreeSet<int[]> set=new TreeSet<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        for(int i=0;i<=len-1;i++){
            char c=chars[i];
            if(c>=65&&c<=90){//大写
                c+=32;
                set.add(new int[]{c,i});
            }else if(c>=97&&c<=122){//小写
                set.add(new int[]{c,i});
            }
        }

        //赋值进去
        char[] resChar= Arrays.copyOfRange(chars,0,len);
        int i=0;
        for(int[] arr:set){
            char c=chars[arr[1]];
            char c2=chars[i];
            while(i<=len-1&&!((c2>=65&&c2<=90)||(c2>=97&&c2<=122))){//不是字符
                i++;
                c2=chars[i];
            }
            if((c2>=65&&c2<=90)||(c2>=97&&c2<=122)){
                resChar[i]=c;
                i++;
            }
        }
        System.out.print(new String(resChar));
    }
}