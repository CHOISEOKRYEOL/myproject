package com.eomcs.pms;

import java.util.Scanner;

public class PhysicalHandler {

  static Scanner scanner= new Scanner(System.in);
  static String str[] = new String[game.LENGTH];
  static String str1[] = new String[game.LENGTH];
  static int size = 0;


  static void view(){
    System.out.println("소인, 중인, 대인");
    str1[size] = scanner.nextLine();
    if(str1[size].equalsIgnoreCase("소인")) {
      System.out.println("소인");
    }    
    else if(str1[size].equalsIgnoreCase("중인")) {
      System.out.println("중인");
    }
    else if(str1[size].equalsIgnoreCase("대인")) {
      System.out.println("대인");
    }
  }
}
