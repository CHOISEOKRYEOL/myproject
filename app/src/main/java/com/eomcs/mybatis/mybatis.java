package com.eomcs.mybatis;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatis {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/mybatis-config.xml")).openSession();

    //    List<Member> members = sqlSession.selectList("MemberMapper.selectMember");
    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");


    //System.out.println(members.size());

    sqlSession.close();

    System.out.println("실행 완료!");
  }

}
