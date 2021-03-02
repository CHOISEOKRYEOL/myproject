package handler;

import util.Prompt;

public class MemberHandler {

  static MemberList memberList = new MemberList();

  public static void add() {

    System.out.println("[선수 등록]");

    MemberList m = new MemberList();

    m.no = Prompt.inputInt("번호 ");
    m.name = Prompt.inputString("이름 ");
    m.nationality = Prompt.inputString("국적 ");
    m.position = Prompt.inputString("포지션 ");

    memberList.add(m);

  }

  public static void list() {

    MemberList[] members = memberList.toArray();

    for(MemberList m : members) {
      System.out.printf("%d, %s, %s, %s\n",m.no,m.name,m.nationality,m.position);
    }
  }

  public static void detail() {
    System.out.println("[선수 정보 상세보기]");

    int no = Prompt.inputInt("번호");

    MemberList member = memberList.get(no);
    if(member == null) {
      System.out.println("해당번호의 선수가 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("국적: %s\n", member.nationality);
    System.out.printf("포지션: %s\n", member.position);
  }

  public static void update() {
    System.out.println("[선수 정보 변경]");

    int no = Prompt.inputInt("번호");

    MemberList member = memberList.get(no);

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

  public static void delete() {
    System.out.println("[선수 삭제]");

    int no = Prompt.inputInt("선수 번호");

    MemberList member = memberList.get(no);

    if(member.no != no) {
      System.out.println("해당번호의 선수가 없습니다.");
      return;
    }
    if (member != null && member.no == no) {
      String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

      if (input.equalsIgnoreCase("Y")) {
        memberList.delete(no);
        System.out.println("선수 정보를 삭제하였습니다.");

      } else {
        System.out.println("선수 정보 삭제를 취소하였습니다.");
      }
    }
  }


}


