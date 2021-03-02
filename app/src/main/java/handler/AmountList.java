package handler;

public class AmountList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static AmountList[] amounts = new AmountList[DEFAULT_CAPACITY];
  public int fowardprice;
  public int midfielderprice;
  public int defenderprice;


  void add(AmountList a) {
    this.amounts[this.size++] = a;
  }

  AmountList[] toArray() {
    AmountList[] arr = new AmountList[this.size];
    for(int i = 0; i < AmountList.size; i++) {
      arr[i] = AmountList.amounts[i];
    }
    return arr;
  }

}
