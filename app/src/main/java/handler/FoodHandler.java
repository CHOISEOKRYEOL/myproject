package handler;

import util.Prompt;

public class FoodHandler {

  static FoodList foodList = new FoodList();

  public static void add() {

    FoodList f = new FoodList();

    System.out.println("[식단 관리]");

    while (true) {
      String name = Prompt.inputString("선수 이름 ");
      for (int i = 0; i < MemberList.size; i++) {
        if (isMember(name)) {
          f.name = name;
          break;
        }
      }
      if (f.name!= null) {
        break;
      }
      System.out.println("등록된 선수가 아닙니다.");
    }

    f.setCarbohydrate( Prompt.inputInt("탄수화물> "));
    f.setProtein(Prompt.inputInt("단백질> "));
    f.setCalcium(Prompt.inputInt("칼슘> "));
    f.setFat(Prompt.inputInt("지방> "));
    f.setVitamin(Prompt.inputInt("비타민> ")) ;

    FoodList.add(f);
  }

  public static void list() {

    FoodList[] foods =  foodList.toArray();

    for(FoodList f : foods) {
      System.out.printf("%s, %d, %d, %d, %d, %d\n", 
          f.name,f.carbohydrate,f.protein,f.calcium,f.fat,f.vitamin);
    }
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
