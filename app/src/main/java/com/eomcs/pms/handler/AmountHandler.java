package com.eomcs.pms.handler;

import java.util.Arrays;
import com.eomcs.util.Prompt;

public class AmountHandler {

  static class Amount {

    int number;
    int fowardprice;
    int midfielderprice;
    int defenderprice;
  } 

  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Amount[] amounts = new Amount[DEFAULT_CAPACITY];
  static int i = 0;

  static int[] number = new int[DEFAULT_CAPACITY];
  static int[] fowardprice = new int[DEFAULT_CAPACITY];
  static int[] midfielderprice = new int[DEFAULT_CAPACITY];
  static int[] defenderprice = new int[DEFAULT_CAPACITY];



  public static void add() {

    Amount a = new Amount();

    System.out.println("[포지션 별 영입 가격]");
    System.out.println();
    a.fowardprice = Prompt.inputInt("공격수 가격 ");
    a.midfielderprice = Prompt.inputInt("미드필더 가격 ");
    a.defenderprice = Prompt.inputInt("수비수 가격 ");

    if (size >= amounts.length) {
      amounts = Arrays.copyOf(amounts, size + (size >> 1));
    }
  }

  public static void list() {

    Amount a = amounts[i];

    int fowardSum = a.fowardprice;
    int midfielderSum = a.midfielderprice;
    int defenderSum = a.defenderprice; 
    long total = a.fowardprice + a.midfielderprice + a.defenderprice;

    System.out.println("[영입 합계]");
    int number = Prompt.inputInt("공격수:1\n 미드필더:2\n 수비수:3\n 총가격:4\n");
    switch(number) {
      case 1:
        System.out.println(fowardSum);
        break;
      case 2:
        System.out.println(midfielderSum);
        break;
      case 3:
        System.out.println(defenderSum);
        break;
      case 4:
        System.out.println(total);
        break;
    }
  }

}
