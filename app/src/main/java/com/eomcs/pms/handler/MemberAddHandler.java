package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddHandler extends AbstractMemberHandler {
  public MemberAddHandler(List<Member> memberList) {
    super(memberList);
  }

  @Override
  public void service() {
    System.out.println("[선수 등록]");

    Member m = new Member();

    m.no = Prompt.inputInt("번호 ");
    m.name = Prompt.inputString("이름 ");
    m.nationality = Prompt.inputString("국적 ");
    m.position = Prompt.inputString("포지션 ");

    memberList.add(m);

  }

  public Member findByName(String name) {
    Member[] list = memberList.toArray(new Member[memberList.size()]);
    for(Member m : list) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    return null;
  }
}
