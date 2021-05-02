package com.eomcs.mybatis;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Catalog;
import com.eomcs.mybatis.vo.Delivery;
import com.eomcs.mybatis.vo.Payment;
import com.eomcs.mybatis.vo.User;

public class mybatis {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/mybatis-config.xml")).openSession();

    List<User> users = sqlSession.selectList("UserMapper.selectUser"); 

    for(User u : users) {    
      System.out.printf("%d,%s,%s,%s,%s,%s,%s,%s", 
          u.getNo(),
          u.getName(),
          u.getAddress(),
          u.getGender(),
          u.getTel(),
          u.getId(),
          u.getPassword(),
          u.getCdt());
    } 

    List<Payment> payments = sqlSession.selectList("PaymentMapper.selectPayment");

    for(Payment p : payments) { 
      System.out.printf("%d,%s,%s,%s,%s,%s,%s,%d",
          p.getNo(),
          p.getName(),
          p.getTitle(),
          p.getPrice(),
          p.getCardnumber(),
          p.getTel(),
          p.getId(),
          p.getStatus());
    }

    List<Catalog> catalogs = sqlSession.selectList("CatalogMapper.selectCatalog");

    for(Catalog c : catalogs) {
      System.out.printf("%d,%s,%s,%s",
          c.getNo(),
          c.getTitle(),
          c.getWriter(),
          c.getPrice());
    }


    List<Delivery> deliveries = sqlSession.selectList("DeliveryMapper.selectDelivery");

    for(Delivery d : deliveries) {
      System.out.printf("%s,%s,%d,%d,%d",
          d.getName(),
          d.getDeliveryNo(),
          d.getSender(),
          d.getDestinataire()
          );
    }


    System.out.println(users.size());
    System.out.println(payments.size());
    System.out.println(catalogs.size());
    System.out.println(deliveries.size());

    sqlSession.close();

    System.out.println("실행 완료!");
  }

}
