package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDeleteHandler extends AbstractMemberHandler {

  public MemberDeleteHandler(List<Member> memberList) {
    super(memberList);
  }
  @Override
  public void service() {
    System.out.println("[선수 삭제]");

    int no = Prompt.inputInt("선수 번호");

    Member member = memberList.get(no);

    if(member.no != no) {
      System.out.println("해당번호의 선수가 없습니다.");
      return;
    }
    if (member != null && member.no == no) {
      String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

      if (input.equalsIgnoreCase("Y")) {
        memberList.remove(no);
        System.out.println("선수 정보를 삭제하였습니다.");

      } else {
        System.out.println("선수 정보 삭제를 취소하였습니다.");
      }
    }
  }
}
