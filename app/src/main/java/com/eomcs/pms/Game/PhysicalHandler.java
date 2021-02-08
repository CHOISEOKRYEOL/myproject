package com.eomcs.pms.Game;

import java.util.Scanner;

public class PhysicalHandler {

  public static class Physical {

    String str1;

  }

  static Scanner scanner= new Scanner(System.in);
  static Physical[] physicals = new Physical[Game.LENGTH]; 
  static int size = 0;


  public static void view(){

    Physical p = new Physical();


    System.out.println("소인, 중인, 대인");
    p.str1 = scanner.nextLine();
    if(p.str1.equalsIgnoreCase("소인")) {
      System.out.println("소인");
    }
    else if(p.str1.equalsIgnoreCase("중인")) {
      System.out.println("중인");
    }
    else if(p.str1.equalsIgnoreCase("대인")) {
      System.out.println("대인");
    }
  }
}
