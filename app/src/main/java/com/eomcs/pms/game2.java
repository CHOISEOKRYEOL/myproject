package com.eomcs.pms;

import java.util.Scanner;

public class game2 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("특징");
    System.out.print(">");
    String feature = scanner.nextLine();

    switch(feature) {
      case "warrior" :
        System.out.println("힘: 10, 민첩: 4, 마나: 1, 공격속도: 5");
        break;
      case "magician" :
        System.out.println("힘: 3, 민첩: 6, 마나: 10, 공격속도: 3");
        break;
      case "archer" :
        System.out.println("힘: 6, 민첩: 6, 마나: 4, 공격속도: 8");
        break;
      case "thief" :
        System.out.println("힘: 5, 민첩: 9, 마나: 5, 공격속도: 6");
        break;
    }


    scanner.close();


  }

}
