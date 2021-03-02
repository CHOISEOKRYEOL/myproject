package handler;

import java.sql.Date;

public class TrainingList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static TrainingList[] trainings = new TrainingList[DEFAULT_CAPACITY];

  public static void add(TrainingList t) {
    trainings[size++] = t;
  }

  public TrainingList[] toArray() {
    TrainingList[] arr = new TrainingList[size];
    for(int i = 0; i < size; i++) {
      arr[i] = trainings[i];
    }
    return arr;
  }

  private static final long serialVersionUID = 1L;
  public String name;
  public String title;
  public String content;
  public Date startDate;
  public Date endDate;
  public int status;
  public String stateLabel;


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Object getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getStateLabel() {
    return stateLabel;
  }
  public void setStateLabel(String stateLabel) {
    this.stateLabel = stateLabel;
  }

}
