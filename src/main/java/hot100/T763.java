package hot100;

import java.util.ArrayList;
import java.util.List;

public class T763 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        boolean[] mark=new boolean[25];
        int[] FirstIndex=new int[25];//记录最早出现的索引
        List<Integer> res=new ArrayList<>();
        int cnt=0;
        char[] chars=s.toCharArray();

        for(int i=0;i<=chars.length-1;i++){
            int c=chars[i]-'a';
            if(mark[c]==false){//不在mark里，可以切分
                if(cnt!=0){
                    res.add(cnt);
                }
                FirstIndex[c]=i;//记录第一次出现的index
                mark[c]=true;
                cnt=1;
            }else{//在mark里面(分在当前区间和在旧区间)
                cnt++;
                int firstI=FirstIndex[c];
                if(firstI>=i-cnt+1){//在当前区间
                }else{//在旧区间
                    int newLength=cnt;
                    while(!res.isEmpty()){
                        newLength+=res.get(res.size()-1);
                        res.remove(res.size()-1);
                        if(firstI>=i-newLength+1){
                            break;
                        }
                    }
                    cnt=newLength;
                }
            }
        }
        if(cnt>0){
            res.add(cnt);
        }
        return res;

    }
}