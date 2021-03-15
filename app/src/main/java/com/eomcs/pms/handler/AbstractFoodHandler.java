package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Food;

public abstract class AbstractFoodHandler implements Command {

  protected List<Food> foodList;

  public AbstractFoodHandler(List<Food> foodList) {
    this.foodList = foodList;
  }
}
