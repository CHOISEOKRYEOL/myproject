package com.eomcs.mybatis;

import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatis {

  public static void main(String[] args) throws Exception {

    InputStream mybatisConfigInputStream = new FileInputStream(
        "./bin/main/com/eomcs/mybatis/mybatis-config.xml");

    SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

    SqlSessionFactory factory = factoryBuilder.build(mybatisConfigInputStream);

    SqlSession sqlSession = factory.openSession();

    System.out.println("mybatis 사용 준비 완료!");

    sqlSession.close();


  }


}
