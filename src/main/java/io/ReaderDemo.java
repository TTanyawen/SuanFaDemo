package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
以字符为单位读取数据
按照UTF-8的存储规则来读取和解析

->
Reader：字符输入流
一次读一个字符
 */
public class ReaderDemo {
    public static void main(String[] args) {
        FileReader in=null;
        try{
            in=new FileReader("E:/SuanFaDemo/SuanFaDemo/src/main/resources/file02.txt");
            char[] chars=new char[100];
            int len;
            while((len=in.read(chars))!=-1){
                System.out.print(new String(chars,0,len));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
