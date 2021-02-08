package com.eomcs.pms.handler;

import com.eomcs.pms.handler.TrainingHandler.Training;

public class TrainingList {

  static final int DEFAULT_CAPACITY = 3;
  static int size = 0;
  static Training[] trainings = new Training[DEFAULT_CAPACITY];

  void add(Training t) {
    trainings[size++] = t;
  }

  Training[] toArray() {
    Training[] arr = new Training[size];
    for(int i = 0; i < size; i++) {
      arr[i] = trainings[i];
    }
    return arr;
  }

  Training get(int trainingNo) {
    int i = indexOf(trainingNo);
    if(i == -1)
      return null;
    return trainings[i];
  }

  void delete(int trainingNo) {
    int index = indexOf(trainingNo);

    if(index == -1)
      return;
    for (int x = index + 1; x < this.size; x++) {
      this.trainings[x-1] = this.trainings[x];
    }
    this.trainings[--this.size] = null;
  }

  public boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (name.equals(this.trainings[i].name)) {
        return true;
      }
    }
    return false;
  }

  int indexOf(int trainingNo) {
    for (int i = 0; i < this.size; i++) {
      Training training = this.trainings[i];
      if (training.no == trainingNo) {
        return i;
      }
    }
    return -1;
  }
}
