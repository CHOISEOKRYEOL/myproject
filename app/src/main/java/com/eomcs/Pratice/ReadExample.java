package com.eomcs.Pratice;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample {

  public static void main(String[] args) throws Exception {
    Reader reader = new FileReader("C:/TEMP/test9.txt");

    char[] buffer = new char[5];


    int readCharNum = reader.read(buffer,2,3);
    if(readCharNum != -1) {
      for(int i = 0; i <buffer.length; i++) {
        System.out.println(buffer[i]);
      }

    }
    reader.close();
  }

}
