package soccer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.pms.domain.Food;
import com.eomcs.util.Prompt;

public class FoodAddHandler  implements Command {


  @Override
  public void service() throws Exception{

    System.out.println("[식단 관리]");

    Food f = new Food();

    f.name = Prompt.inputString("이름: ");
    f.carbohydrate = Prompt.inputInt("탄수화물: ");
    f.protein = Prompt.inputInt("단백질: ");
    f.calcium = Prompt.inputInt("칼슘: ");
    f.fat = Prompt.inputInt("지방: ");
    f.vitamin = Prompt.inputInt("비타민: ");


    try(Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into soccer_food(name,carbohydrate,protein,calcium,fat,vitamin) values(?,?,?,?,?,?)");) {

      stmt.setString(1, f.getName());
      stmt.setInt(2, f.getCarbohydrate());
      stmt.setInt(3, f.getProtein());
      stmt.setInt(4, f.getCalcium());
      stmt.setInt(5, f.getFat());
      stmt.setInt(6, f.getVitamin());

      stmt.executeUpdate();

      System.out.println("식단 관리 등록 완료!");

    }
  }
}
