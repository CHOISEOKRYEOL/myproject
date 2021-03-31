package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.pms.domain.Training;
import com.eomcs.util.Prompt;

public class TrainingAddHandler implements Command {

  @Override
  public void service() throws Exception {

    System.out.println("[훈련 관리]");

    Training t = new Training();

    t.name = Prompt.inputString("이름: ");
    t.title = Prompt.inputString("제목: ");
    t.content = Prompt.inputString("내용: ");
    t.sdt = Prompt.inputDate("시작일: ");
    t.edt= Prompt.inputDate("종료일: ");
    t.status = Prompt.inputInt(" 대기중: 1\n 진행중: 2\n 완료: 3\n");


    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_training(name,title,content,sdt,edt,status) values(?,?,?,?,?,?)");) {


      stmt.setString(1, t.getName());
      stmt.setString(2, t.getTitle());
      stmt.setString(3, t.getContent());
      stmt.setDate(4, t.getSdt());
      stmt.setObject(5, t.getEdt());
      stmt.setInt(6, t.getStatus());
      stmt.executeUpdate();

      System.out.println("훈련 관리 등록 완료!");

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
