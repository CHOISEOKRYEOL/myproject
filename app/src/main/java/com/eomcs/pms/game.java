package com.eomcs.pms;

import java.util.Scanner;

public class game {

  static Scanner scanner= new Scanner(System.in);

  static final int LENGTH = 4;

  static String inputString(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }

  public static void main(String[] args) {

    loop:
      while(true) {
        System.out.println();
        System.out.print("명령");
        System.out.print(">");
        String commend = scanner.nextLine();

        switch(commend) {
          case "setjob": 
            JobHandler.set();
            break;
          case "viewjob" :
            JobHandler.view();
            break;
          case "stat" :
            StatHandler.view();
            break;
          case "physical" :
            PhysicalHandler.view();
            break;
          case "exit" :
            System.out.println("Bye");
            break loop;
        }
      }
    scanner.close();
  }
}

