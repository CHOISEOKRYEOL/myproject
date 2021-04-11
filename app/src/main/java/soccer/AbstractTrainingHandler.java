package soccer;

import java.util.List;
import com.eomcs.pms.domain.Training;

public abstract class AbstractTrainingHandler implements Command {

  protected List<Training> trainingList;

  public AbstractTrainingHandler(List<Training> trainingList) {
    this.trainingList = trainingList;
  }

}
