package com.eomcs.Pratice;

import java.io.File;

public class Pratice {
  public static void main(String[] args) throws Exception {
    File dir = new File("temp");
    deleteFile(dir);
  }
  static void deleteFile(File dir) {

    if(dir.isDirectory()) {
      File[] files = dir.listFiles();
      for(File file : files) {
        deleteFile(file);
      }
    }
    dir.delete();
  }
}
