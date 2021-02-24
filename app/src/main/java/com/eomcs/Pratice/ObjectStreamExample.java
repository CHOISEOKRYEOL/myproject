package com.eomcs.Pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectStreamExample {
  public static void main(String[] args) throws Exception {
    writeList();
    List<Board1> list = readList();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for(Board1 board : list) {
      System.out.println(
          board.getBno() + "\t" + board.getTitle() + "\t" +
              board.getContent() + "\t" + board.getWriter() + "\t" +
              sdf.format(board.getDate())
          );
    }
  }
  public static void writeList() throws Exception {
    List<Board1> list = new ArrayList<>();

    list.add(new Board1(1, "제목", "내용1", "글쓴이1", new Date()));
    list.add(new Board1(2, "제목", "내용1", "글쓴이2", new Date()));
    list.add(new Board1(3, "제목", "내용1", "글쓴이3", new Date()));

    FileOutputStream fos = new FileOutputStream("C:/TEMP/board.db");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(list);
    oos.flush();
    oos.close();
  }
  public static List<Board1> readList() throws Exception {

    FileInputStream fis = new FileInputStream("C:/TEMP/board.db");
    ObjectInputStream ois = new ObjectInputStream(fis);
    List<Board1> list = (List<Board1>) ois.readObject();
    return list;
  }
}
