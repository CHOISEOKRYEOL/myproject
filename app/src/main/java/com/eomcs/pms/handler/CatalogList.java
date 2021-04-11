package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Food;

public class CatalogList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static Food[] foods = new Food[DEFAULT_CAPACITY];

  static void add(Food f) {
    foods[size++] = f;
  }

  Food[] toArray() {
    Food[] arr = new Food[this.size];
    for(int i = 0; i < this.size; i++) {
      arr[i] = this.foods[i];
    }
    return arr;
  }


}

