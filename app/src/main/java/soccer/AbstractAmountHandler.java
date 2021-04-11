package soccer;

import java.util.List;
import com.eomcs.pms.domain.Amount;

public abstract class  AbstractAmountHandler implements Command{
  protected List<Amount> amountList;

  public AbstractAmountHandler(List<Amount> amountList) {
    this.amountList = amountList;
  }

  public static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static Amount[] amounts = new Amount[DEFAULT_CAPACITY];

  void add(Amount a) {
    this.amounts[this.size++] = a;
  }

  Amount[] toArray() {
    Amount[] arr = new Amount[this.size];
    for(int i = 0; i < Amount.size; i++) {
      arr[i] = this.amounts[i];
    }
    return arr;
  }
}
