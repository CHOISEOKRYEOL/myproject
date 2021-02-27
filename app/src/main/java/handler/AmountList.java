package handler;

import domain.Amount;

public class AmountList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static Amount[] amounts = new Amount[DEFAULT_CAPACITY];

  void add(Amount a) {
    this.amounts[this.size++] = a;
  }

  Amount[] toArray() {
    Amount[] arr = new Amount[this.size];
    for(int i = 0; i < this.size; i++) {
      arr[i] = this.amounts[i];
    }
    return arr;
  }

}
