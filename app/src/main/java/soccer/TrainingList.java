package soccer;

import com.eomcs.pms.domain.Training;

public class TrainingList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static Training[] trainings = new Training[DEFAULT_CAPACITY];

  public static void add(Training t) {
    trainings[size++] = t;
  }

  public Training[] toArray() {
    Training[] arr = new Training[size];
    for(int i = 0; i < size; i++) {
      arr[i] = trainings[i];
    }
    return arr;
  }
}
