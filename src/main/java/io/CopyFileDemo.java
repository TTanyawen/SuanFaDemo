package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo {
    public static void main(String[] args) {
        copyFile("E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261704.txt",
                "E:/SuanFaDemo/SuanFaDemo/src/main/resources/12261704_copy.txt");
    }
    public static void copyFile(String srcPath,String destPath){
        FileInputStream in=null;
        FileOutputStream out=null;
        try{
            in=new FileInputStream(srcPath);
            out=new FileOutputStream(destPath);
            byte[] bytes=new byte[1024];
            int len;
            while((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
