package com.io;

import java.io.File;
import java.io.IOException;

public class FileOperations {

    public void getWorkingDir(File d) {
        //获取JVM的当前工作目录
        String  workingDir = System.getProperty("user.dir");
        //更改当前工作目录
        //System.setProperty("user.dir", "///");
        //查看文件是否存在
        boolean fileExists = d.exists();

        System.out.println(workingDir);
        System.out.println(fileExists);
    }

    //        创建目录
    public void createDir(File d) {
//       仅当路径名中指定的父目录已存在时，mkdir()方法才创建目录。
        d.mkdir();

//      mkdirs()方法创建一个文件夹和它的所有父文件夹。
//        d.mkdirs();

    }

    //读取目录
    public void readDir(File d,String dirName) {
        //        检查是否是目录
        if (d.isDirectory()) {
            System.out.println("it is directory");
        }

//        提取它包含的文件和文件夹的列表
        //list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
        String s[] = d.list();
        for (int i = 0; i < s.length; i++) {
            File f = new File(dirName + "/" + s[i]);
            if (f.isDirectory()) {
                System.out.println(s[i] + "is a directory");
            } else {
                System.out.println(s[i] +"is a file");
            }

        }
    }

    //删除目录下所有文件及目录   目录必须为空，我们才能删除它。
    public void deleteDir(File d) {
        //listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
        File[] files = d.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteDir(d);
                } else {
                    f.delete();  //删除文件
                }
            }
            d.delete(); //删除文件夹
        }
        //当程序退出时删除
        //d.deleteOnExit();
    }

    public void createFile(File f) throws IOException {
        boolean fileCreated = f.createNewFile();

        File  tempFile = File.createTempFile("abc", ".txt");
    }


    public void renameFile(File f) {

        File newFile = new File("new.txt");
        boolean fileRenamed = f.renameTo(newFile);
    }


}
