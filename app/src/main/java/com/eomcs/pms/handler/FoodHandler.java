package com.eomcs.pms.handler;

import java.util.Arrays;
import com.eomcs.util.Prompt;

public class FoodHandler {

  static class Food {
    String name;
    String carbohydrate;
    String protein;
    String calcium;
    String fat;
    String vitamin;
  } 

  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Food[] foods = new Food[DEFAULT_CAPACITY];

  static String[] carbohydrate = new String[DEFAULT_CAPACITY];
  static String[] protein = new String[DEFAULT_CAPACITY];
  static String[] calcium = new String[DEFAULT_CAPACITY];
  static String[] fat = new String[DEFAULT_CAPACITY];
  static String[] vitamin = new String[DEFAULT_CAPACITY];

  public static void add() {

    Food f = new Food();

    System.out.println("[식단 관리]");

    while (true) {
      String name = Prompt.inputString("수강생 이름 ");
      for (int i = 0; i < MemberHandler.size; i++) {
        if (isMember(name)) {
          f.name = name;
          break;
        }
      }
      if (f.name!= null) {
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    f.carbohydrate = Prompt.inputString("탄수화물> ");
    f.protein = Prompt.inputString("단백질> ");
    f.calcium = Prompt.inputString("칼슘> ");
    f.fat = Prompt.inputString("지방> ");
    f.vitamin = Prompt.inputString("비타민> ");

    if (size >= foods.length) {
      foods = Arrays.copyOf(foods, size + (size >> 1));

      foods[size++] = f;
    }
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
