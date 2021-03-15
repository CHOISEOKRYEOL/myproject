package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Training;
import com.eomcs.util.Prompt;

public class TrainingAddHandler extends AbstractTrainingHandler {

  public TrainingAddHandler(List<Training> trainingList) {
    super(trainingList);
  }

  @Override
  public void service() {

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

  static boolean isMember(String name) {
    for (int i = 0; i < MemberList.size; i++) {
      if (name.equals(MemberList.members[i].getName())) {
        return true;
      }
    }
    return false;
  }

}
