package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddHandler implements Command {

  @Override
  public void service() throws Exception {
    System.out.println("[선수 등록]");

    Member m = new Member();

    m.name = Prompt.inputString("이름 ");
    m.nationality = Prompt.inputString("국적 ");
    m.position = Prompt.inputString("포지션 ");

    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_member(name,nationality,position) values(?,?,?)");) {

      stmt.setString(1, m.getName());
      stmt.setString(2, m.getNationality());
      stmt.setString(3, m.getPosition());
      stmt.executeUpdate();

      System.out.println("선수 등록 완료!");

    }


  }

  /*
  public Member findByName(String name) {
    Member[] list = memberList.toArray(new Member[memberList.size()]);
    for(Member m : list) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    return null;
  }
   */
}
