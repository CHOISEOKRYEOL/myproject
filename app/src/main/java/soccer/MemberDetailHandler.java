package soccer;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDetailHandler extends AbstractMemberHandler {

  public MemberDetailHandler(List<Member> memberList) {
    super(memberList);
  }

  @Override
  public void service() {

    System.out.println("[선수 정보 상세보기]");

    int no = Prompt.inputInt("번호");

    Member member = memberList.get(no);
    if(member == null) {
      System.out.println("해당번호의 선수가 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("국적: %s\n", member.nationality);
    System.out.printf("포지션: %s\n", member.position);
  }

}
