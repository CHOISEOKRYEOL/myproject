package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.util.Prompt;

public class TrainingHandler {


  static class Training {
    int no;
    String title;
    String content;
    Date startDate;
    Date endtDate;
    public Object endDate;
  } 

  static Scanner scanner = new Scanner(System.in);

  static final int LENGTH = 100; 
  static int size = 0;
  static Training[] trainings = new Training[LENGTH];

  static int[] no = new int[LENGTH];
  static String[] title = new String[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] startDate = new Date[LENGTH];
  static Date[] endDate = new Date[LENGTH];



  public static void add() {

    Training t = new Training();

    System.out.println("[훈련 내용]");

    t.no =  Prompt.inputInt("등번호");
    t.title = Prompt.inputString("제목 ");
    t.content = Prompt.inputString("내용 ");
    t.startDate = Prompt.inputDate("시작일 ");
    t.endDate = Prompt.inputDate("종료일 ");

    while (true) {
      int i = 0;
      int no = Prompt.inputInt("수강생");
      if (no == 0) {
        System.out.println("수강생 훈련을 취소합니다.");
        return;
      } 
      System.out.println("등록된 수강생이 아닙니다.");
    }

  }  

  public static void list() {

    for (int i = 0; i < size; i++) {
      Training t = trainings[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          t.no, t.title,t.content, t.startDate, t.endDate);
    }
  }

}
