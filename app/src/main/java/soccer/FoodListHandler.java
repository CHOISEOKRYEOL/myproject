package soccer;

import java.util.List;
import com.eomcs.pms.domain.Food;

public class FoodListHandler extends AbstractFoodHandler{

  public FoodListHandler(List<Food> foodList) {
    super(foodList);
  }

  @Override
  public void service() {

    Object[] list = foodList.toArray();

    for(Object obj : list) {
      Food f = (Food) obj;
      System.out.printf("%s, %d, %d, %d, %d, %d\n", 
          f.name,f.carbohydrate,f.protein,f.calcium,f.fat,f.vitamin);
    }
  }

}

