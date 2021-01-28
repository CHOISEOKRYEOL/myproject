package com.eomcs.pms;

import java.util.Scanner;
import com.eomcs.pms.handler.JobHandler;
import com.eomcs.pms.handler.PhysicalHandler;
import com.eomcs.pms.handler.StatHandler;
import com.eomcs.util.Prompt;

public class Game {

  public static Scanner scanner= new Scanner(System.in);

  public static final int LENGTH = 100;

  static String inputString(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }

  public static void main(String[] args) {

    loop:
      while(true) {
        System.out.println();
        System.out.print("stat, physical, setjob, viewjob, setjob/detail, setjob/update");
        System.out.print(">");
        String commend = scanner.nextLine();

        System.out.println();

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
          case "setjob/detail": 
            JobHandler.detail(); 
            break;
          case "setjob/update": 
            JobHandler.update(); 
            break;
          case "exit" :
            System.out.println("Bye~!");
            break loop;
        }
      }
    Prompt.close();
  }

}


