package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String dirName = "/Users/dx/DEV/Java/IOOperations/files/";
        File d = new File(dirName);
        File f = new File("text.txt");

        char chr = 'g';
        String str = "hello";
        byte[] by = str.getBytes();
        IOOperations i = new IOOperations();
        //i.writeFile(by);
        //i.readFile();
        //i.bwriteFile(by);
        //i.breadFile();
        //i.cwriteFile(chr);
        //i.creadFile();
        //i.printFile();



        //FileOperations fop = new FileOperations();
        //fop.createDir(d);
        //fop.readDir(d,dirName);
        //fop.deleteDir(d);
        //fop.getWorkingDir(d);
        //fop.createFile(f);
        //fop.renameFile(f);

        String s = "hello good";
        byte[] b = s.getBytes();
        for (byte be : b) {
            System.out.println(be);
        }

        String ns = new String(b);
        System.out.println(ns);


    }
}
