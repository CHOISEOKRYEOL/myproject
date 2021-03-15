package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Amount;
import com.eomcs.util.Prompt;

public class AmountAddHandler extends AbstractAmountHandler {

  public AmountAddHandler(List<Amount> amountList) {
    super(amountList);
  }

  @Override
  public void service() {

    Amount a = new Amount();

    System.out.println("[포지션 별 영입 가격]");
    System.out.println();
    a.fowardprice = Prompt.inputInt("공격수 영입금액 ");
    a.midfielderprice = Prompt.inputInt("미드필더 영입금액 ");
    a.defenderprice = Prompt.inputInt("수비수 영입금액 ");

    amountList.add(a);

  }



}
