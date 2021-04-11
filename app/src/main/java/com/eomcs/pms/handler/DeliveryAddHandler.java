package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.mybatis.vo.Delivery;
import com.eomcs.util.Prompt;

public class DeliveryAddHandler implements Command {

  @Override
  public void service() throws Exception{
    System.out.println("[배송]");

    Delivery d = new Delivery();

    d.name = Prompt.inputString("이름 ");
    d.deliveryNo = Prompt.inputString("송장번호: ");
    d.sender = Prompt.inputString("보내는 분: ");
    d.destinataire = Prompt.inputString("받는 분: ");

    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_amount(name,fowardprice,sender,destinataire) values(?,?,?,?)");) {

      stmt.setString(1, d.getName());
      stmt.setString(2, d.getDeliveryNo());
      stmt.setString(3, d.getSender());
      stmt.setString(4, d.getDestinataire());
      stmt.executeUpdate();

      System.out.println("배송 관리 완료!");

    }

  }
}
