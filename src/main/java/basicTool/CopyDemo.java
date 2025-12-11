package basicTool;
/*
   浅拷贝vs深拷贝

   浅拷贝：实现Cloneable接口和接口的clone方法，但是类内的引用类型指向的对象的所属类没有实现Cloneable接口
   深拷贝
    1. 所有相关的类都实现Cloneable接口和接口的clone方法，并且手动在clone方法内调用成员的clone
    2. 序列化和反序列化
        使用 ByteArrayOutputStream & ObjectOutputStream  & ByteArrayInputStream  &  ObjectInputStream
        注意相关类需要 implements Serializable接口
    3. 手动递归复制，自己去new对象
 */

import java.io.*;

class A{
    String code;
    public A(String code){
        this.code=code;
    }
}
class B implements Cloneable{
    A a;
    String str;
    public B(String str,A a){
        this.str=str;
        this.a=a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 浅拷贝
    }

}

class C implements Cloneable{
    String code;
    public C(String code){
        this.code=code;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class D implements Cloneable{
    C c;
    String str;
    public D(String str,C c){
        this.str=str;
        this.c=c;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        D d=(D)super.clone();
        d.c=(C)c.clone();//手动调用
        return d;
    }

}


class E implements Serializable{
    String code;
    public E(String code){
        this.code=code;
    }
}
class F implements Serializable {
    E e;
    String str;
    public F(String str,E e){
        this.str=str;
        this.e=e;
    }

    //序列化反序列化进行deep copy
    public F deepCopy(){
        try{
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bis);

            return (F)ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

public class CopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {


        //浅拷贝
        A a=new A("code");
        B b=new B("str",a);
        B b2=(B)b.clone();
        System.out.println("修改前："+a.code);
        b2.a.code="newCode";//修改b2,但是a被更改，说明b2的a引用变量指向旧的a对象
        System.out.println("修改后："+a.code);

        //深拷贝方法1
        C c=new C("code");
        D d=new D("str",c);
        D d2=(D)d.clone();
        System.out.println("修改前："+c.code);
        d2.c.code="newCode";
        System.out.println("修改后："+c.code);

        //深拷贝方法1
        E e=new E("code");
        F f=new F("str",e);
        F f2=f.deepCopy();
        System.out.println("修改前："+e.code);
        f2.e.code="newCode";
        System.out.println("修改后："+e.code);

    }
}
