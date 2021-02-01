package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.Arrays;
import com.eomcs.util.Prompt;

public class TrainingHandler {


  static class Training {
    int no;
    String student;
    String title;
    String content;
    Date startDate;
    public Object endDate;
  } 

  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Training[] trainings = new Training[DEFAULT_CAPACITY];

  static int[] no = new int[DEFAULT_CAPACITY];
  static String[] title = new String[DEFAULT_CAPACITY];
  static String[] content = new String[DEFAULT_CAPACITY];
  static Date[] startDate = new Date[DEFAULT_CAPACITY];
  static Date[] endDate = new Date[DEFAULT_CAPACITY];



  public static void add() {

    Training t = new Training();

    System.out.println("[훈련 내용]");

    t.student =  Prompt.inputString("이름");
    t.title = Prompt.inputString("제목 ");
    t.content = Prompt.inputString("내용 ");
    t.startDate = Prompt.inputDate("시작일 ");
    t.endDate = Prompt.inputDate("종료일 ");

    while (true) {
      String name = Prompt.inputString("수강생 이름 ");
      for (int i = 0; i < MemberHandler.size; i++) {
        if (isMember(name)) {
          t.student = name;
          break;
        }
      }
      if (t.student != null) {
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    if (size >= trainings.length) {
      trainings = Arrays.copyOf(trainings, size + (size >> 1));
    }

    trainings[size++] = t;
  }

  public static void list() {

    for (int i = 0; i < size; i++) {
      Training t = trainings[i];
      System.out.printf("%d, %s, %s, %s, %s, %s\n",
          t.no, t.student,t.title,t.content, t.startDate, t.endDate);
    }
  }

  static boolean isMember(String name) {
    for (int i = 0; i < MemberHandler.size; i++) {
      if (name.equals(MemberHandler.members[i].name)) {
        return true;
      }
    }
    return false;
  }
}
