package jni;
/*
1.declare native method
2.get .h file
    go to jni/ and run:
        javac MyNativeMethodExample.java
    go to java/ and run:
        javac -h jni jni\MyNativeMethodExample.java
    make sure that .h file and cpp file under jni/
3. run:
 g++ -shared -o MyNativeMethodExample.dll -I"$env:JAVA_HOME\include" -I"$env:JAVA_HOME\include\win32" MyNativeMethodExample.cpp

 and hava dll generated
4. cd .. to java/ and run:
java "-Djava.library.path=./jni" jni.MyNativeMethodExample

and got result:
(base) PS E:\SuanFaDemo\SuanFaDemo\src\main\java> java "-Djava.library.path=./jni" jni.MyNativeMethodExample
3 + 5 = 8


 */
public class MyNativeMethodExample {

    public native int add(int a, int b);

    // load library
    static {
        System.loadLibrary("MyNativeMethodExample");
    }

    public static void main(String[] args) {
        MyNativeMethodExample example = new MyNativeMethodExample();
        int result = example.add(3, 5);
        System.out.println("3 + 5 = " + result);
    }
}
