package com.eomcs.mybatis;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatis {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/mybatis-config.xml")).openSession();

    List<Member> members = sqlSession.selectList("MemberMapper.selectMember");

    System.out.println(members.size());

    sqlSession.close();

  }

}
