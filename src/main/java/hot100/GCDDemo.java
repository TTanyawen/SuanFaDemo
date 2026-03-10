package hot100;

public class GCDDemo {
    public static void main(String[] args) {
        System.out.println(gcd(17*23,17*21));
    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
