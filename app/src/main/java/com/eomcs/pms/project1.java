package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class project1 {

  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] registeredDate = new Date[LENGTH];

    int[] pno = new int[LENGTH];
    String[] ptitle = new String[LENGTH];
    String[] pcontent = new String[LENGTH];
    Date[] pstartDate = new Date[LENGTH];
    Date[] pendDate = new Date[LENGTH];
    String[] powner = new String[LENGTH];
    String[] pmembers = new String[LENGTH];

    int size = 0;
    int psize = 0;

    loop:
      while (true) {
        System.out.print("명령");
        System.out.print(">");
        String commend = keyboardScan.nextLine();

        switch(commend) {

          case "/member/add" :
            System.out.println("회원 등록");

            for (int i = 0; i < LENGTH; i++) {
              System.out.print("번호? ");
              no[i] = Integer.parseInt(keyboardScan.nextLine());

              System.out.print("이름? ");
              name[i] = keyboardScan.nextLine();

              System.out.print("이메일? ");
              email[i] = keyboardScan.nextLine();

              System.out.print("암호? ");
              password[i] = keyboardScan.nextLine();

              System.out.print("사진? ");
              photo[i] = keyboardScan.nextLine();

              System.out.print("전화? ");
              tel[i] = keyboardScan.nextLine();

              registeredDate[i] = new java.sql.Date(System.currentTimeMillis());

              size++;

              System.out.print("계속 입력하시겠습니까?(y/N) ");
              String str = keyboardScan.nextLine();
              if (!str.equalsIgnoreCase("y")) {
                break;
              }
            }
          case "/member/list":
            System.out.println("회원 목록");

            for (int i = 0; i < size; i++) {
              // 번호, 이름, 이메일, 전화, 가입일
              System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
                  no[i], name[i], email[i], tel[i], registeredDate[i]);
            }
            break;
          case "/project/add" :
            for (int i = 0; i < LENGTH; i++) {
              System.out.print("번호? ");
              no[i] = Integer.valueOf(keyboardScan.nextLine());

              System.out.print("프로젝트명? ");
              ptitle[i] = keyboardScan.nextLine();

              System.out.print("내용? ");
              pcontent[i] = keyboardScan.nextLine();

              System.out.print("시작일? ");
              pstartDate[i] = Date.valueOf(keyboardScan.nextLine());

              System.out.print("종료일? ");
              pendDate[i] = Date.valueOf(keyboardScan.nextLine());

              System.out.print("만든이? ");
              powner[i] = keyboardScan.nextLine();

              System.out.print("팀원? ");
              pmembers[i] = keyboardScan.nextLine();

              psize++;
              System.out.println(); // 빈 줄 출력

              System.out.print("계속 입력하시겠습니까?(y/N) ");
              String str = keyboardScan.nextLine();
              if (!str.equalsIgnoreCase("y")) {
                break;
              }
            }
          case "/project/list":
            System.out.println("회원 목록");

            for (int i = 0; i < psize; i++) {
              // 번호, 이름, 이메일, 전화, 가입일
              System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
                  pno[i], ptitle[i], pcontent[i], pstartDate[i], pendDate[i],powner[i],pmembers[i]);
            }
            break;
          case "exit" :
          case "quit" :
            System.out.println("안녕~~!!!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }

      }
  }
}
