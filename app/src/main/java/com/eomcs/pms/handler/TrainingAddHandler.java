package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.mybatis.vo.Payment;
import com.eomcs.util.Prompt;

public class TrainingAddHandler implements Command {

  @Override
  public void service() throws Exception {

    System.out.println("[결제 관리]");

    Payment p = new Payment();

    p.name = Prompt.inputString("이름: ");
    p.title = Prompt.inputString("제목: ");
    p.price = Prompt.inputString("가격: ");
    p.cardNumber = Prompt.inputString("카드번호: ");
    p.tel= Prompt.inputString("전화번호: ");
    p.id = Prompt.inputString("아이디: ");
    p.status = Prompt.inputInt(" 결제중: 1\n 완료: 2\n");


    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_training(no,name,title,price,cardNumber,tel,id,status) values(?,?,?,?,?,?,?,?)");) {

      stmt.setInt(1, p.getNo());
      stmt.setString(1, p.getName());
      stmt.setString(2, p.getTitle());
      stmt.setString(3, p.getPrice());
      stmt.setString(4, p.getCardnumber());
      stmt.setString(5, p.getTel());
      stmt.setString(6, p.getId());
      stmt.setInt(1, p.getStatus());

      stmt.executeUpdate();

      System.out.println("결제 관리 등록 완료!");

      /*
       String stateLabel = null;
      switch(t.status) {
        case 1:
          t.stateLabel = "대기중";
        case 2:
          t.stateLabel = "진행중";
          break;
        case 3:
          t.stateLabel = "완료";
          break;
      }
       */
    }
  }
}
