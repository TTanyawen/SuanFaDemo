package basicTool;

public class StringDemo {
    public static void main(String[] args) {
        String s="ascfg";
        System.out.println(s.substring(1,2));
        char[] S=s.toCharArray();
        for(char c: s.toCharArray()){
            System.out.print(c+" ");
        }System.out.println();

        char[] c={'a','b'};
        String s2=new String(c);
        System.out.println(s2);

        StringBuilder sb=new StringBuilder();
        sb.append("abc");
        sb.append("def");
        System.out.println(sb.reverse() .toString());


    }
}
