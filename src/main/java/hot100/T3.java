package hot100;

import java.util.HashMap;
import java.util.Map;


class T3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int len=s.length();
        int res=0;
        int start=0;
        for(int i=0;i<=len-1;i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
            }else{
                int index=map.get(c);
                //remove[start,index]
                for(int j=start;j<=index;j++){
                    map.remove(s.charAt(j));
                }
                start=index+1;
                map.put(c,i);


            }

            res=Math.max(res,map.size());
        }
        return res;
    }
}