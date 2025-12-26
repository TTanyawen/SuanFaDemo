package io;

import java.io.File;
import java.io.IOException;

public class CreateRenameAndDeleteDemo {
    public static void main(String[] args) throws IOException {
//        createFile();
//        renameFile();
//        deleteFile();

//        createDir();
//        renameDir();
//        deleteDir();

//        createDirs();

        boolean res=deleteDirs(new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/dir2025_1"));
        if(res){
            System.out.println("递归删除成功");
        }else{
            System.out.println("递归删除失败");
        }
    }
    //创建文件
    public static void createFile() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/file2025_1.txt");
        if(!file.exists()){
            boolean res=file.createNewFile();
            System.out.println("创建文件结果: "+res);
        }else{
            System.out.println("创建文件失败");
        }
    }
    //重命名文件
    public static void renameFile() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/file2025_1.txt");
        File file1=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/file2025_2.txt");
        if(file.exists()){
            boolean res=file.renameTo(file1);
            System.out.println("重命名结果: "+res);
        }else{
            System.out.println("重命名失败");
        }
    }
    //删除文件
    public static void deleteFile() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/file2025_2.txt");
        if(file.exists()){
            boolean res=file.delete();
            System.out.println("删除结果: "+res);
        }else{
            System.out.println("删除失败");
        }
    }

    //创建目录
    public static void createDir() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/dir2025_1");
        if(!file.exists()){
            boolean res=file.mkdir();
            System.out.println("创建目录结果: "+res);
        }else{
            System.out.println("创建目录失败");
        }
    }
    //重命名目录
    public static void renameDir() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/dir2025_1");
        File file1=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/dir2025_2");
        if(file.exists()){
            boolean res=file.renameTo(file1);
            System.out.println("重命名结果: "+res);
        }else{
            System.out.println("重命名失败");
        }
    }

    //删除目录
    public static void deleteDir() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/dir2025_2");
        if(file.exists()){
            boolean res=file.delete();
            System.out.println("删除结果: "+res);
        }else{
            System.out.println("删除失败");
        }
    }
    //创建多级目录
    public static void createDirs() throws IOException {
        File file=new File("E:/SuanFaDemo/SuanFaDemo/src/main/resources/dir2025_1/dir2025_2");
        if(!file.exists()){
            boolean res=file.mkdirs();
            System.out.println("创建多级目录结果: "+res);
        }else{
            System.out.println("创建多级目录失败");
        }
        System.out.println("多级目录创建成功");
    }
    //递归删除目录
    public static boolean deleteDirs(File file){
        if(file.isDirectory()&&file.exists()){
            File[] files=file.listFiles();
            if(files!=null){
                for(File f:files){
                    deleteDirs(f);
                }
            }
        }
        return file.delete();

    }
}
