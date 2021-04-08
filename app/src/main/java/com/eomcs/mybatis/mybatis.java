package com.eomcs.mybatis;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Amount;
import com.eomcs.mybatis.vo.Food;
import com.eomcs.mybatis.vo.Member;
import com.eomcs.mybatis.vo.Training;

public class mybatis {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/mybatis-config.xml")).openSession();

    List<Member> members = sqlSession.selectList("MemberMapper.selectMember");

    for(Member m : members) {  
      System.out.printf("%d,%s,%s,%s", 
          m.getNo(),
          m.getName(),
          m.getNationality(),
          m.getPosition());
    } 

    List<Training> trainings = sqlSession.selectList("TrainingMapper.selectTraining");

    for(Training t : trainings) { 
      System.out.printf("%d,%s,%s,%s,%s,%s,%d",
          t.getNo(),
          t.getName(),
          t.getTitle(),
          t.getContent(),
          t.getSdt(),
          t.getEdt(),
          t.getStatus());
    }

    List<Food> foods = sqlSession.selectList("FoodMapper.selectFood");

    for(Food f : foods) {
      System.out.printf("%s,%d,%d,%d,%d,%d",
          f.getName(),
          f.getCarbohydrate(),
          f.getProtein(),
          f.getCalcium(),
          f.getFat(),
          f.getVitamin());
    }


    List<Amount> amounts = sqlSession.selectList("AmountMapper.selectAmount");

    for(Amount a : amounts) {
      System.out.printf("%s,%s,%d,%d,%d",
          a.getName(),
          a.getScoutname(),
          a.getFowardprice(),
          a.getMidfielderprice(),
          a.getDefenderprice()
          );
    }


    System.out.println(members.size());
    System.out.println(trainings.size());
    System.out.println(foods.size());
    System.out.println(amounts.size());

    sqlSession.close();

    System.out.println("실행 완료!");
  }

}
