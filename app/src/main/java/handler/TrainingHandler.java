package handler;

import domain.Training;
import util.Prompt;

public class TrainingHandler {

  static TrainingList trainingList = new TrainingList();

  public static void add() {

    Training t = new Training();

    System.out.println("[훈련 내용]");

    while (true) {
      String name = Prompt.inputString("이름 ");
      for (int i = 0; i < MemberList.size; i++) {
        if (isMember(name)) {
          t.name = name;
          break;
        }
      }
      if (t.name != null) {
        break;
      }
      System.out.println("등록된 선수가 아닙니다.");
    }
    t.title = Prompt.inputString("제목 ");
    t.content = Prompt.inputString("내용 ");
    t.startDate = Prompt.inputDate("시작일 ");
    t.endDate = Prompt.inputDate("종료일 ");
    t.status = Prompt.inputInt(" 진행중: 1\n 완료: 2\n");
    String stateLabel = null;
    switch(t.status) {
      case 1:
        t.stateLabel = "진행중";
        break;
      case 2:
        t.stateLabel = "완료";
        break;
    }
    TrainingList.add(t);
  }

  public static void list() {

    Training[] trainings = trainingList.toArray();

    for (Training t : trainings) {
      System.out.printf(" %s, %s, %s, %s, %s, %s\n",
          t.name,t.title,t.content, t.startDate, t.endDate, t.stateLabel);
    }
  }


  static boolean isMember(String name) {
    for (int i = 0; i < MemberList.size; i++) {
      if (name.equals(MemberList.members[i].name)) {
        return true;
      }
    }
    return false;
  }
}
