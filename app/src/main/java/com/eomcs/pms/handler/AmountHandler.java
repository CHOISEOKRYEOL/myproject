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
  static int fowardSum = 0;
  static int midfielderSum = 0;;
  static int defenderSum = 0;
  static  long total =0;

  static int[] number = new int[DEFAULT_CAPACITY];
  static int[] fowardprice = new int[DEFAULT_CAPACITY];
  static int[] midfielderprice = new int[DEFAULT_CAPACITY];
  static int[] defenderprice = new int[DEFAULT_CAPACITY];



  public static void add() {

    Amount a = new Amount();

    System.out.println("[포지션 별 영입 가격]");
    System.out.println();
    a.fowardprice = Prompt.inputInt("공격수 영입금액 ");
    a.midfielderprice = Prompt.inputInt("미드필더 영입금액 ");
    a.defenderprice = Prompt.inputInt("수비수 영입금액 ");

    if (size >= amounts.length) {
      amounts = Arrays.copyOf(amounts, size + (size >> 1));
    }
    amounts[size++] = a;
  }

  public static void list() {


    for(int i = 0; i < size; i++) {
      fowardSum += amounts[i].fowardprice; 
      midfielderSum += amounts[i].midfielderprice;
      defenderSum += amounts[i].defenderprice;
      total  += amounts[i].fowardprice + amounts[i].midfielderprice + amounts[i].defenderprice;
    }



    System.out.println("[영입 합계 금액]");
    int number = Prompt.inputInt("공격수:1\n미드필더:2\n수비수:3\n총가격:4\n>>>>>>>>");
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
    fowardSum = 0;
    midfielderSum = 0;
    defenderSum = 0;
    total = 0;
  }

}
