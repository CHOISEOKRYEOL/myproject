package handler;

import java.util.Arrays;
import domain.Food;
import util.Prompt;

public class FoodHandler {


  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Food[] foods = new Food[DEFAULT_CAPACITY];

  static int[] carbohydrate = new int[DEFAULT_CAPACITY];
  static int[] protein = new int[DEFAULT_CAPACITY];
  static int[] calcium = new int[DEFAULT_CAPACITY];
  static int[] fat = new int[DEFAULT_CAPACITY];
  static int[] vitamin = new int[DEFAULT_CAPACITY];

  public static void add() {

    Food f = new Food();

    System.out.println("[식단 관리]");

    while (true) {
      String name = Prompt.inputString("선수 이름 ");
      for (int i = 0; i < MemberHandler.size; i++) {
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

    if (size >= foods.length) {
      foods = Arrays.copyOf(foods, size + (size >> 1));
    }
    foods[size++] = f;
  }

  private static void setProtein(int inputInt) {

  }

  private static void setCarbohydrate(int inputInt) {

  }

  public static void list() {

    for (int i = 0; i < size; i++) {
      Food f = foods[i];
      System.out.printf("%s, %s, %s, %s, %s, %s\n",
          f.name, f.carbohydrate,f.protein,f.calcium, f.fat, f.vitamin);
    }
  }
  static boolean isMember(String name) {
    for (int i = 0; i < MemberHandler.size; i++) {
      if (name.equals(MemberHandler.members[i].name)) {
        return true;
      }
    }
    return false;
  }

}
