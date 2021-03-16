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

    t.name = Prompt.inputString("이름: ");
    t.title = Prompt.inputString("제목: ");
    t.content = Prompt.inputString("내용: ");
    t.startDate = Prompt.inputDate("시작일: ");
    t.endDate = Prompt.inputDate("종료일: ");
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
    trainingList.add(t);
  }
}
