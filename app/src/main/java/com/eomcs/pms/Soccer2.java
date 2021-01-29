package com.eomcs.pms;

import java.util.Scanner;

public class Soccer2 {

  public static void main(String[] args) {
    System.out.println("[선수 특징]");

    Scanner scanner = new Scanner(System.in);


    final int LENGTH = 100;

    String[] tall = new String[LENGTH];
    String[] weight = new String[LENGTH];
    String[] chestsize = new String[LENGTH];
    String[] foot = new String[LENGTH];

    int size = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("키? ");
      tall[i] = scanner.nextLine();

      System.out.print("몸무게? ");
      weight[i] = scanner.nextLine();

      System.out.print("가슴둘레? ");
      chestsize[i] = scanner.nextLine();

      System.out.print("축구화 사이즈? ");
      foot[i] = scanner.nextLine();

      size++;
      System.out.println();

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = scanner.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println(); 
    }

    scanner.close();

    System.out.println("--------------------------------");


    for (int i = 0; i < size; i++) {

      System.out.printf("%d, %s, %s, %s, %s\n",
          tall[i], weight[i], chestsize[i], foot[i]);
    }
  }
}
