package com.eomcs.pms.handler;

import com.eomcs.pms.Game;

public class StatHandler {

  static int size = 0;

  String str = Game.scanner.nextLine();

  public static void view() {

    System.out.println("warrior, magician, archer, thief");
    String str= Game.scanner.nextLine();
    if(str.equalsIgnoreCase("warrior")) {
      System.out.println("힘: 10, 민첩: 4, 마나: 1, 공격속도: 5");
    }    
    else if(str.equalsIgnoreCase("magician")) {
      System.out.println("힘: 3, 민첩: 6, 마나: 10, 공격속도: 3");
    }
    else if(str.equalsIgnoreCase("archer")) {
      System.out.println("힘: 6, 민첩: 6, 마나: 4, 공격속도: 8");
    }
    else if(str.equalsIgnoreCase("thief"))
      System.out.println("힘: 5, 민첩: 9, 마나: 5, 공격속도: 6");
  }

}
