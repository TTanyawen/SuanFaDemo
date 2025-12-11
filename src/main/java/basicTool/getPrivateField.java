package basicTool;

import java.lang.reflect.Field;

class GetPrivateFieldCls {
    private int i;
    public GetPrivateFieldCls(int i){
        this.i=i;
    }
}
public class getPrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        GetPrivateFieldCls getPrivateFieldCls = new GetPrivateFieldCls(99);

        //1
        Class<?> clazz = getPrivateFieldCls.getClass();
        //2
        Field field_i = clazz.getDeclaredField("i");
        //3
        field_i.setAccessible(true);
        //4
        int value =(Integer)field_i.get(getPrivateFieldCls);
        System.out.println(value);
    }
}
