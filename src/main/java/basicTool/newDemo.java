package basicTool;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicLongArray;

/*
新建一个对象的方法
1. new
2. Class类的newInstance
3. Contructor类的newInstance
4. clone
5. 序列化反序列化
 */
class NewDemoCls implements Cloneable,Serializable{
    int i=10;
    public NewDemoCls(){

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

public class newDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException, ClassNotFoundException {
        //1
        NewDemoCls newDemoCls = new NewDemoCls();

        //2
        NewDemoCls newDemoCls2=NewDemoCls.class.newInstance();

        //3
        Constructor<NewDemoCls> constructor=NewDemoCls.class.getConstructor();
        NewDemoCls newDemoCls3=constructor.newInstance();

        //4
        NewDemoCls newDemoCls4=(NewDemoCls)newDemoCls3.clone();

        //5
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("xx.dat"));
        oos.writeObject(newDemoCls4);

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("xx.dat"));
        NewDemoCls newDemoCls5=(NewDemoCls)ois.readObject();

    }
}
