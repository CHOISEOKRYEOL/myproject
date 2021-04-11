package soccer;

import java.util.List;
import com.eomcs.pms.domain.Member;

public abstract class AbstractMemberHandler implements Command{

  protected List<Member> memberList;

  public AbstractMemberHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

}
