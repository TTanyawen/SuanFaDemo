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
            但是char的真实数据范围是0-65535,而read可以读到0-255的字节，用byte返回的话会丢信息
            EOF是-1
            一个是因为byte装不下所有char
            一个是因为11111111作为数据可以表示255，作为byte则等于-1
            如果等于-1则无法区分EOF的-1和作为字符的11111111

            -1的
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
        readFile("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261717.txt");
        System.out.println((char)228);//ä
        System.out.println((char)184);//¸
        System.out.println((char)173);//­



//        char c='ÿ';
//        System.out.println(c+"---"+(int)c);

    }
    public static void readFile(String filePath) {
        FileInputStream in=null;
        try {
            in = new FileInputStream(filePath);
            int b;//字节值
            while ((b = in.read()) != -1) {
                System.out.println((char) b);
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
