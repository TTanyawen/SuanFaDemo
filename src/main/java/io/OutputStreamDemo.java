package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {
    public static void main(String[] args) {
        outputTofile("hello world","E:/SuanFaDemo/SuanFaDemo/src/main/resources/output01.txt");

    }

    //写入内容到文件
    public static void outputTofile(String content,String filePath) {
        FileOutputStream out=null;
        try{
            File file=new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            out=new FileOutputStream(file);
            String str=content;
            byte[] bytes=str.getBytes();
            out.write(bytes);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(out!=null){
                try{
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
