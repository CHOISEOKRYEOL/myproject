package com.eomcs.pms;

import java.util.Scanner;
import com.eomcs.pms.handler.FoodHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.TrainingHandler;

public class Soccer {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    loop:
      while (true) {

        System.out.println("명령>");
        String commend = scanner.nextLine();

        switch (commend) {
          case "/member/add":
            MemberHandler.add();
            break;
          case "/member/list":
            MemberHandler.list();
            break;
          case "/member/detail":
            MemberHandler.detail();
            break;
          case "/member/update":
            MemberHandler.update();
            break;
          case "/member/delete":
            MemberHandler.delete();
            break;
          case "/training/add":
            TrainingHandler.add();
            break;
          case "/training/list":
            TrainingHandler.list();
            break;
          case "/food/add":
            FoodHandler.add();
            break;
          case "/food/list":
            FoodHandler.list();
            break;
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println(); 
      }
    scanner.close();
  }
}
