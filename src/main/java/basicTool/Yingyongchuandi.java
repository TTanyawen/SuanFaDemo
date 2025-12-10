package basicTool;
class Person{
    int age;
}
//理解引用传递传的是引用副本，而不是引用本身
public class Yingyongchuandi {

    public static void modifyArr(int[] arr_inside){
        arr_inside[0]=99;//通过引用修改数组本身

        //这里修改了引用指向的数组，但是外部引用没有改变，因为传递的是副本
        arr_inside=new int[3];
        arr_inside[0]=5;
        arr_inside[1]=6;
        arr_inside[2]=7;
    }
    public static void modifyPerson(Person p){
        p=new Person();
        System.out.println("inside p:"+p);
    }


    public static void main(String[] args) {
        int[] arr_outside={1,2,3};
        modifyArr(arr_outside);
        for(int num:arr_outside){
            System.out.print(num+" ");
        }System.out.println();

        Person p=new Person();
        System.out.println("outside p:"+p);
        modifyPerson(p);
        System.out.println("outside p:"+p);
    }
}
