package io;

import java.io.FileWriter;

/*
Writer
字符输出流
 */
public class WriterDemo {
    public static void main(String[] args) {
        FileWriter out=null;
        try{
            out=new FileWriter("E:/SuanFaDemo/SuanFaDemo/src/main/resources/file02.txt", true);
            out.write("hello world");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null){
                try{
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
