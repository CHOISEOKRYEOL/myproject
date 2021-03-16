package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Food;
import com.eomcs.util.Prompt;

public class FoodAddHandler  extends AbstractFoodHandler {

  public FoodAddHandler(List<Food> foodList) {
    super(foodList);
  }

  @Override
  public void service() {

    Food f = new Food();

    System.out.println("[식단 관리]");


    f.setName( Prompt.inputString("선수 이름 "));
    f.setCarbohydrate( Prompt.inputInt("탄수화물> "));
    f.setProtein(Prompt.inputInt("단백질> "));
    f.setCalcium(Prompt.inputInt("칼슘> "));
    f.setFat(Prompt.inputInt("지방> "));
    f.setVitamin(Prompt.inputInt("비타민> ")) ;

    foodList.add(f);

  }

  static boolean isMember(String name) {
    for (int i = 0; i < MemberList.size; i++) {
      if (name.equals(MemberList.members[i].name)) {
        return true;
      }
    }
    return false;
  }



}
