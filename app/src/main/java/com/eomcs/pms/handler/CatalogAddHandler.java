package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.mybatis.vo.Catalog;
import com.eomcs.util.Prompt;

public class CatalogAddHandler  implements Command {


  @Override
  public void service() throws Exception{

    System.out.println("[도서 목록]");

    Catalog c = new Catalog();

    c.title = Prompt.inputString("제목: ");
    c.writer = Prompt.inputString("저자: ");
    c.price = Prompt.inputString("가격: ");


    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_food(no,title,writer,price) values(?,?,?,?)");) {

      stmt.setInt(1,c.getNo());
      stmt.setString(2, c.getTitle());
      stmt.setString(3, c.getWriter());
      stmt.setString(4, c.getPrice());

      stmt.executeUpdate();

      System.out.println("도서 목록 등록 완료!");

    }
  }
}
