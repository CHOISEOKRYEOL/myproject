package com.eomcs.pms.handler;

import com.eomcs.pms.handler.FoodHandler.Food;

public class FoodList {
  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Food[] foods = new Food[DEFAULT_CAPACITY];

  void add(Food f) {
    foods[size++] = f;
  }

  Food[] toArray() {
    Food[] arr = new Food[size];
    for(int i = 0; i < size; i++) {
      arr[i] = foods[i];
    }
    return arr;
  }

  Food get(int memberNo) {
    int i = indexOf(memberNo);
    if(i == -1)
      return null;
    return foods[i];
  }

  void delete(int memberNo) {
    int index = indexOf(memberNo);

    if(index == -1)
      return;
    for (int x = index + 1; x < this.size; x++) {
      this.foods[x-1] = this.foods[x];
    }
    this.foods[--this.size] = null;
  }

  public boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (name.equals(this.foods[i].name)) {
        return true;
      }
    }
    return false;
  }

  int indexOf(int foodsNo) {
    for (int i = 0; i < this.size; i++) {
      Food food = this.foods[i];
      if (food.no == foodsNo) {
        return i;
      }
    }
    return -1;
  }

}
