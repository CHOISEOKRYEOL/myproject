package com.eomcs.Pratice;

import java.io.File;

public class Practice {

  public static void main(String[] args) throws Exception {

    File dir = new File(".");
    System.out.println(dir.getCanonicalPath());

    printList(dir ,1);
  }

  static void printList(File dir, int level) {
    File[] files = dir.listFiles();

    for(File file : files) {
      printIndent(level);
      if(file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      }else if (file.isFile()) {
        System.out.print("\\--");
        System.out.printf("%s\n", file.getName());
      }
    }
  }
  static void printIndent(int level) {
    for (int i = 0; i <level; i++) {
      System.out.print(" ");
    }
  } 
}