package com.eomcs.pms.handler;

import com.eomcs.util.Prompt;

public class MemberHandler {

  static class Member {
    int no;
    String name;
    String nationality;
    String position;
  } 

  static final int LENGTH = 100; 
  static int size = 0;
  static Member[] members = new Member[LENGTH];

  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] nationality = new String[LENGTH];
  static String[] position = new String[LENGTH];

  public static void add() {

    System.out.println("[선수 등록]");

    Member m = new Member();

    m.no = Prompt.inputInt("번호 ");
    m.name = Prompt.inputString("이름 ");
    m.nationality = Prompt.inputString("국적 ");
    m.position = Prompt.inputString("포지션 ");

    members[size++] = m;

  }

  public static void list() {
    for (int i = 0; i < size; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s\n", 
          m.no, m.name, m.nationality, m.position);
    }
  }

  public static void detail() {
    System.out.println("[선수 정보 상세보기]");

    int no = Prompt.inputInt("선수 번호");

    for (int i = 0; i < size; i++) {
      Member m = members[i];
      if (m.no == no) {
        System.out.printf("이름: %s\n", m.name);
        System.out.printf("국적: %s\n", m.nationality);
        System.out.printf("포지션: %s\n", m.position);
        return;
      }
    }
    System.out.println("해당 번호의 선수는 없습니다.");
  }

  public static void update() {
    System.out.println("[선수 정보 변경]");

    int no = Prompt.inputInt("번호 ");

    for (int i = 0; i < size; i++) {
      Member m = members[i];
      if (m.no == no) {
        String name = Prompt.inputString(String.format("이름(%s)? ", m.name));
        String nationality = Prompt.inputString(String.format("국적(%s)? ", m.nationality));
        String position = Prompt.inputString(String.format("포지션(%s)? ", m.position));


        String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

        if (input.equalsIgnoreCase("Y")) {
          m.name = name;
          m.nationality = nationality;
          m.position = position;
          System.out.println("선수 정보가 변경되었습니다.");

        } else {
          System.out.println("선수 정보 변경을 취소하였습니다.");
        }
        return;
      }
    }
  }

  public static void delete() {
    System.out.println("[선수 삭제]");

    int no = Prompt.inputInt("선수 번호");

    for (int i = 0; i < size; i++) {
      Member m = members[i];
      if (m != null && m.no == no) {
        String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

        if (input.equalsIgnoreCase("Y")) {
          for (int x = i + 1; x < size; x++) {
            members[x-1] = members[x];
          }
          members[--size] = null; 
          System.out.println("선수 정보를 삭제하였습니다.");

        } else {
          System.out.println("선수 정보 삭제를 취소하였습니다.");
        }

        return;
      }
    }

    System.out.println("해당 번호의 선수 정보가 없습니다.");

  }

  int indexOf(int memberNo) {
    for (int i = 0; i < size; i++) {
      Member m = members[i];
      if (m != null && m.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

  Member findByNo(int memberNo) {
    int i = indexOf(memberNo);
    if (i == -1) 
      return null;
    else 
      return members[i];
  }
}


