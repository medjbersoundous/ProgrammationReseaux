package TP2;
import java.io.*;

public class ListDirectory {
    public static void main(String[] args) {
        File dir = new File("d:/");
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.print(file.isDirectory() ? "Directory" : "File");
                    System.out.print(file.canRead() ? " Readable" : " Not Readable");
                    System.out.print(file.canWrite() ? " Writable" : " Not Writable");
                    System.out.println(" -> " + file.getName());
                }
            }
        } else {
            System.out.println("Ce n'est pas un répertoire.");
        }
    }
}
