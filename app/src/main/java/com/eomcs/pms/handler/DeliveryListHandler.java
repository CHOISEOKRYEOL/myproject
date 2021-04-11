package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Amount;
import com.eomcs.util.Prompt;

public class DeliveryListHandler extends AbstractAmountHandler {
  public DeliveryListHandler(List<Amount> amountList) {
    super(amountList);
  }

  static int i = 0;
  static int fowardSum = 0;
  static int midfielderSum = 0;
  static int defenderSum = 0;
  static long total =0;

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static Amount[] amounts = new Amount[DEFAULT_CAPACITY];
  public int fowardprice;
  public int midfielderprice;
  public int defenderprice;

  @Override
  public void service() {

    Object[] list = amountList.toArray();

    for(Object obj : list) {
      Amount a = (Amount) obj;
      System.out.printf("%d, %d, %d\n" ,
          a.fowardprice,
          a.midfielderprice,
          a.defenderprice);
    }

    for(Amount a :amountList) {
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

