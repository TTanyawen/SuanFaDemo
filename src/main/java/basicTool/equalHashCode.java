package basicTool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
重写equals和hashCode方法
 */
class Personk{
    String name;
    String code;
    public Personk(String name,String code){
        this.name=name;
        this.code=code;
    }
    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass()) return false;
        Personk personk=(Personk) o;
        return Objects.equals(code,personk.code) && Objects.equals(name,personk.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

}
public class equalHashCode {
    public static void main(String[] args) {
        Personk p1=new Personk("name1","code1");
        Personk p2=new Personk("name1","code1");
        Set<Personk> set=new HashSet<>();


        set.add(p1);
        System.out.println(set.contains(p2));
    }
}
