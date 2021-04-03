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

    List<Training> trainings = sqlSession.selectList("TrainingMapper.selectTraining");

    List<Food> foods = sqlSession.selectList("FoodMapper.selectFood");

    List<Amount> amounts = sqlSession.selectList("AmountMapper.selectAmount");

    System.out.println(members.size());
    System.out.println(trainings.size());
    System.out.println(foods.size());
    System.out.println(amounts.size());

    sqlSession.close();

    System.out.println("실행 완료!");
  }

}
