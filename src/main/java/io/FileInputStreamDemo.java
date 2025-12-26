package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {


//        readFile("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261704.txt");

        //为什仫read返回int
        /*
            byte的取值范围-128-127
            因为-1需要返回给调用者来判断读取结束，如果返回byte的话，如果是读到(11111111)(255)，则无法判断是EOF还是数据
            byte的-1的补码：11111111

         */
//        for(int i=0;i<=65535;i++){
//            System.out.println(i+"---"+((char)i));
//        }

        /*
        读取“中”
        中在utf-8中用三个字符表示
ä
¸
­
它们分别返回228，184，173

         */
//        readFile("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261717.txt");
//        System.out.println((char)228);//ä
//        System.out.println((char)184);//¸
//        System.out.println((char)173);//­



//        char c='ÿ';
//        System.out.println(c+"---"+(int)c);

        //批量读取多个字节
        /*
            可能的问题：多读字符
            文件里是abceabc, 读取出来却是abceabce
            通过len解决，忽视掉多读进byte数组的就好了
         */
//        readFileMulti("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261759.txt");
        readFile("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261812.txt");

    }
    public static void readFile(String filePath) {
        FileInputStream in=null;
        try {
            in = new FileInputStream(filePath);
            int b;//字节值
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void readFileMulti(String filePath) {
        FileInputStream in=null;
        try {
            in = new FileInputStream(filePath);
            byte[] bytes=new byte[4];
            int len;
            while ((len=in.read(bytes)) != -1) {//这里read返回的是读取的字节数
                System.out.print(new String(bytes,0,len));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }



}
