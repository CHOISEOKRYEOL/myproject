package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateHandler extends AbstractMemberHandler {

  public MemberUpdateHandler(List<Member> memberList) {
    super(memberList);
  }

  @Override
  public void service() {
    System.out.println("[선수 정보 변경]");

    int no = Prompt.inputInt("번호");

    Member member = memberList.get(no);

    if(member.no != no) {
      System.out.println("해당번호의 선수가 없습니다.");
      return;
    }
    String name1 = Prompt.inputString(String.format("이름(%s)? ", member.name));
    String nationality = Prompt.inputString(String.format("국적(%s)? ", member.nationality));
    String position = Prompt.inputString(String.format("포지션(%s)? ", member.position));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      member.name = name1;
      member.nationality = nationality;
      member.position = position;
      System.out.println("선수 정보가 변경되었습니다.");

    } else {
      System.out.println("선수 정보 변경을 취소하였습니다.");
    }
    return;

  }
}
