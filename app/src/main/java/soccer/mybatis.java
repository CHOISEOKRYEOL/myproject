package soccer;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Delivery;
import com.eomcs.mybatis.vo.Catalog;
import com.eomcs.mybatis.vo.User;
import com.eomcs.mybatis.vo.Payment;

public class mybatis {

  public static void main(String[] args) throws Exception {

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/mybatis-config.xml")).openSession();

    List<User> users = sqlSession.selectList("MemberMapper.selectMember");

    for(User m : users) {   
      System.out.printf("%d,%s,%s,%s", 
          m.getNo(),
          m.getName(),
          m.getNationality(),
          m.getPosition());
    } 

    List<Payment> payments = sqlSession.selectList("TrainingMapper.selectTraining");

    for(Payment t : payments) { 
      System.out.printf("%d,%s,%s,%s,%s,%s,%d",
          t.getNo(),
          t.getName(),
          t.getTitle(),
          t.getContent(),
          t.getSdt(),
          t.getEdt(),
          t.getStatus());
    }

    List<Catalog> catalogs = sqlSession.selectList("FoodMapper.selectFood");

    for(Catalog f : catalogs) {
      System.out.printf("%s,%d,%d,%d,%d,%d",
          f.getName(),
          f.getCarbohydrate(),
          f.getProtein(),
          f.getCalcium(),
          f.getFat(),
          f.getVitamin());
    }


    List<Delivery> deliveries = sqlSession.selectList("AmountMapper.selectAmount");

    for(Delivery a : deliveries) {
      System.out.printf("%s,%s,%d,%d,%d",
          a.getName(),
          a.getScoutname(),
          a.getFowardprice(),
          a.getMidfielderprice(),
          a.getDefenderprice()
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
