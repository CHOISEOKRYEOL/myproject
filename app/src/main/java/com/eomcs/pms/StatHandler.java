package com.eomcs.pms;

public class StatHandler {

  static int size = 0;

  static void view() {

    System.out.println("warrior, magician, archer, thief");
    PhysicalHandler.str[size] = game.scanner.nextLine();
    if(PhysicalHandler.str[size].equalsIgnoreCase("warrior")) {
      System.out.println("힘: 10, 민첩: 4, 마나: 1, 공격속도: 5");
    }    
    else if(PhysicalHandler.str[size].equalsIgnoreCase("magician")) {
      System.out.println("힘: 3, 민첩: 6, 마나: 10, 공격속도: 3");
    }
    else if(PhysicalHandler.str[size].equalsIgnoreCase("archer")) {
      System.out.println("힘: 6, 민첩: 6, 마나: 4, 공격속도: 8");
    }
    else if(PhysicalHandler.str[size].equalsIgnoreCase("thief"))
      System.out.println("힘: 5, 민첩: 9, 마나: 5, 공격속도: 6");
  }

}
