package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.mybatis.vo.User;
import com.eomcs.util.Prompt;

public class UserAddHandler implements Command {

  @Override
  public void service() throws Exception {
    System.out.println("[이용객 등록]");

    User u = new User();

    u.name = Prompt.inputString("이름 ");
    u.address = Prompt.inputString("주소 ");
    u.gender = Prompt.inputString("성별 ");
    u.tel = Prompt.inputString("전화번호 ");
    u.id = Prompt.inputString("아이디 ");
    u.password = Prompt.inputString("비밀번호 ");

    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_member(no,name,address,gender,tel,id,password,cdt) values(?,?,?,?,?,?,?,?)");) {

      stmt.setInt(1,u.getNo());
      stmt.setString(2, u.getName());
      stmt.setString(3, u.getAddress());
      stmt.setString(4, u.getGender());
      stmt.setString(5, u.getTel());
      stmt.setString(6, u.getId());
      stmt.setString(7, u.getPassword());
      stmt.setDate(8, u.getCdt());
      stmt.executeUpdate();

      System.out.println("이용객 등록 완료!");

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
