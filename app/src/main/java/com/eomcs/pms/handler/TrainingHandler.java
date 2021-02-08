package com.eomcs.pms.handler;

import java.sql.Date;
import java.util.Arrays;
import com.eomcs.util.Prompt;

public class TrainingHandler {


  static class Training {
    String name;
    String title;
    String content;
    Date startDate;
    public Object endDate;
    int status;
    String stateLabel;
  } 

  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Training[] trainings = new Training[DEFAULT_CAPACITY];

  static int[] no = new int[DEFAULT_CAPACITY];
  static String[] title = new String[DEFAULT_CAPACITY];
  static String[] content = new String[DEFAULT_CAPACITY];
  static Date[] startDate = new Date[DEFAULT_CAPACITY];
  static Date[] endDate = new Date[DEFAULT_CAPACITY];
  static int[] status = new int[DEFAULT_CAPACITY];
  static String[] stateLabel = new String[DEFAULT_CAPACITY];



  public static void add() {

    Training t = new Training();

    System.out.println("[훈련 내용]");

    while (true) {
      String name = Prompt.inputString("이름 ");
      for (int i = 0; i < MemberHandler.size; i++) {
        if (isMember(name)) {
          t.name = name;
          break;
        }
      }
      if (t.name != null) {
        break;
      }
      System.out.println("등록된 선수가 아닙니다.");
    }
    t.title = Prompt.inputString("제목 ");
    t.content = Prompt.inputString("내용 ");
    t.startDate = Prompt.inputDate("시작일 ");
    t.endDate = Prompt.inputDate("종료일 ");
    t.status = Prompt.inputInt(" 진행중: 1\n 완료: 2\n");
    String stateLabel = null;
    switch(t.status) {
      case 1:
        t.stateLabel = "진행중";
        break;
      case 2:
        t.stateLabel = "완료";
        break;
    }

    if (size >= trainings.length) {
      trainings = Arrays.copyOf(trainings, size + (size >> 1));
    }
    trainings[size++] = t;
  }

  public static void list() {

    for (int i = 0; i < size; i++) {
      Training t = trainings[i];
      System.out.printf(" %s, %s, %s, %s, %s, %s\n",
          t.name,t.title,t.content, t.startDate, t.endDate, t.stateLabel);
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
