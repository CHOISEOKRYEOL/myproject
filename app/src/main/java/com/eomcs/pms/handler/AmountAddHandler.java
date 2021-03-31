package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.pms.domain.Amount;
import com.eomcs.util.Prompt;

public class AmountAddHandler implements Command {

  @Override
  public void service() throws Exception{
    System.out.println("[이적료]");

    Amount a = new Amount();

    a.name = Prompt.inputString("이름 ");
    a.fowardprice = Prompt.inputInt("공격수 가격: ");
    a.midfielderprice = Prompt.inputInt("미드필더 가격: ");
    a.defenderprice = Prompt.inputInt("수비수 가격: ");

    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_amount(name,fowardprice,midfielderprice,defenderprice) values(?,?,?,?)");) {

      stmt.setString(1, a.getName());
      stmt.setInt(2, a.getFowardprice());
      stmt.setInt(3, a.getMidfielderprice());
      stmt.setInt(4, a.getDefenderprice());
      stmt.executeUpdate();

      System.out.println("이적료 관리 완료!");

    }

  }
}
