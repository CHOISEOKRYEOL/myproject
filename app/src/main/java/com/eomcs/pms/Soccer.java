package com.eomcs.pms;

import java.util.Scanner;
import java.util.Stack;
import com.eomcs.pms.handler.AmountHandler;
import com.eomcs.pms.handler.FoodHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.TrainingHandler;
import com.eomcs.util.Prompt;

public class Soccer {

  static Stack commandStack  = new Stack();

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws CloneNotSupportedException {

    loop:
      while (true) {
        System.out.println("명령>");
        String command = scanner.nextLine();

        commandStack.push(command);

        try {
          switch (command) {
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
            case "/amount/add":
              AmountHandler.add();
              break;
            case "/amount/list":
              AmountHandler.list();
              break;
            case "history" :
              printCommandHistory();
              break;
            case "exit":
              System.out.println("안녕!");
              break loop;
            default:
              System.out.println("실행할 수 없는 명령입니다.");
          }
        } catch(Exception e) {
          System.out.println("--------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생: %s - %s\n", e.getClass().getName(), e.getMessage());
          System.out.println("--------------------------------------------");
        }
        System.out.println(); 
      }
    scanner.close();
  }

  static void printCommandHistory() throws CloneNotSupportedException {
    Stack stack = (Stack) commandStack.clone();

    int count = 0;
    while(stack.size() > 0) {
      System.out.println(stack.pop());
      if((++count % 5) == 0) {
        String input = Prompt.inputString(" : ");
        if(input.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}
