package com.eomcs.Pratice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStreamExample {
  public static void main(String[] args) {

    String originalFilePath1 = NonBufferVsBufferExample.class.getResource("originalFile1.jpg").getPath();
    String targetFilePath1 = "C:/TEMP/targetFile1.jpg";
    FileInputStream fis = new FileInputStream(originalFilePath1);
    FileOutputStream fos = new FileOutputStream(targetFilePath1);

    String originalFilePath2 = NonBufferVsBufferExample.class.getResource("originalFile2.jpg").getPath();
    String targetFilePath2 = "C:/TEMP/targetFile2.jpg";
    FileInputStream fis2 = new FileInputStream(originalFilePath2);
    FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
    BufferedInputStream bis = new BufferedInputStream(fis2);
    BufferedOutputStream bos = new BufferedOutputStream(fos2);

    long nonBufferTime = copy(fis,fos);
    System.out.println("버퍼를 사용하지 않았을 때:\t" + nonBufferTime + "ns");

    long bufferTime = copy(bis,bos);
    System.out.println("버퍼를 사용하지 않았을 때:\t" + nonBufferTime + "ns");

    fis.close();
    fos.close();
    bis.close();
    bos.close();

  }
  static int data = -1;
  public static long copy(InputStream is, OutputStream os) throws Exception {
    long start = System.nanoTime();
    while(true) {
      data = is.read();
      if(data == -1) break;
      os.write(data);

    }
    os.flush();
    long end = System.nanoTime();
    return(end-start);
  }
}
