package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261704.txt");
            int b;//字节值
            while ((b = in.read()) != -1) {
                System.out.println((char) b);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
