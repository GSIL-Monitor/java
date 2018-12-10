package com.io;

import java.io.*;

public class IOOperations {

    public void writeFile(byte[] by) throws IOException {
        FileOutputStream fout = new FileOutputStream("text.txt");
        fout.write(by);
        fout.flush();
        fout.close();
    }

    //读取文件内容
    public void readFile() throws IOException {
        FileInputStream fin = new FileInputStream("text.txt");
        byte byteData;
        while ((byteData = (byte) fin.read()) != -1) {
            System.out.print((char)byteData);
        }
    }

    public void bwriteFile(byte[] by) throws IOException {
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("text.txt"));
        //插入新行
        String lineSeparator = System.getProperty("line.separator");
        bout.write(lineSeparator.getBytes());

        bout.write(by);
        //使用flush()方法刷新输出流
        bout.flush();
        bout.close();
    }

    public void breadFile() throws IOException {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream("text.txt"));
        byte byteData;
        while ((byteData = (byte) bin.read()) != -1) {
            System.out.print((char)byteData);
        }
        bin.close();
    }

    public void cwriteFile(char chr) throws IOException {
        FileWriter fw = new FileWriter("new.txt",true);//true参数为追加写入
        fw.write(chr);
        fw.flush();
        fw.close();

    }

    public void creadFile() throws IOException {
        FileReader fr = new FileReader("new.txt");
        char[] chr = new char[1024];
        while ((fr.read(chr)) != -1) {
            System.out.print(chr);
        }
        fr.close();
    }

    public void printFile() throws FileNotFoundException {
        PrintStream ps = new PrintStream("new.txt");
        ps.print("goodjob");

    }

}
