package handler;

import util.Prompt;

public class AmountHandler {

  static AmountList amountList = new AmountList();

  static int i = 0;
  static int fowardSum = 0;
  static int midfielderSum = 0;
  static int defenderSum = 0;
  static long total =0;

  public static void add() {

    AmountList a = new AmountList();

    System.out.println("[포지션 별 영입 가격]");
    System.out.println();
    a.fowardprice = Prompt.inputInt("공격수 영입금액 ");
    a.midfielderprice = Prompt.inputInt("미드필더 영입금액 ");
    a.defenderprice = Prompt.inputInt("수비수 영입금액 ");

    amountList.add(a);
  }

  public static void list() {


    AmountList[] amounts = amountList.toArray();

    for(AmountList a : amounts) {
      System.out.printf("%d, %d, %d\n" ,
          a.fowardprice,
          a.midfielderprice,
          a.defenderprice);
    }

    for(AmountList a :amounts) {
      fowardSum += a.fowardprice;
      midfielderSum += a.midfielderprice;
      defenderSum += a.defenderprice;
      total += (a.fowardprice + a.midfielderprice +a.defenderprice);
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
