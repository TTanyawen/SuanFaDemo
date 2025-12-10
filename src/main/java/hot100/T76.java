package hot100;

import java.util.*;


class T76 {
    static String res;
    public static void main(String[] args) {
        String s = "ab";
        String t = "b";

        System.out.println(minWindow(s,t));
    }
    public static boolean modify(Map<Character,Integer> map,Map<Character,Integer> cnt,Set<Character> set,Deque<Integer> deque,String s,String t){
        int flag=1;
        Iterator<Character> it=set.iterator();
        while(it.hasNext()){
            char ele=it.next();
            System.out.print(ele+":"+map.get(ele)+" ,");
            System.out.println();
            if(map.get(ele)<cnt.get(ele)){
                flag=0;
                break;
            }
        }


        if(flag==1){

            char tmpc=s.charAt(deque.peekFirst());

            String tmp=s.substring(deque.peekFirst(), deque.peekLast()+1);
            System.out.println(tmp);
            if(res==null||res.length()>tmp.length()){
                System.out.println("res:"+tmp);
                res=tmp;

            }
            deque.removeFirst();
            map.put(tmpc,map.get(tmpc)-1);
            return true;
        }else{
            return false;
        }


    }


    public static String minWindow(String s, String t) {
        int lens=s.length();
        int lent=t.length();

        Set<Character> set=new HashSet<>();
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> cnt=new HashMap<>();
        Deque<Integer> deque=new LinkedList<>();

        for(int i=0;i<=lent-1;i++){
            char c=t.charAt(i);
            set.add(c);
            cnt.put(c,cnt.containsKey(c)?cnt.get(c)+1:1);
            map.put(c,0);
        }

        for(int i=0;i<=lens-1;i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                map.put(c,map.get(c)+1);
                deque.addLast(i);
                boolean flag=modify(map,cnt,set,deque,s,t);
                while(flag){
                    flag=modify(map,cnt,set,deque,s,t);
                }

            }

        }
        while(!deque.isEmpty()){
            boolean flag=modify(map,cnt,set,deque,s,t);
            if(!flag){
                break;
            }
        }
//        System.out.println(res);
        return res==null?"":res;
    }
}