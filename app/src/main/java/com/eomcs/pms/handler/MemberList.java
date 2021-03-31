package com.eomcs.pms.handler;
/*
import com.eomcs.pms.domain.Member;

public class MemberList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static Member[] members = new Member[DEFAULT_CAPACITY];

  public void add(Member m) {
    members[size++] =  m;
  }

  public Member[] toArray() {
    Member[] arr = new Member[size];
    for(int i = 0; i < size; i++) {
      arr[i] = members[i];
    }
    return arr;
  }

  public Member get(int memberNo) {
    int i = indexOf(memberNo);
    if(i == -1)
      return null;
    return members[i];
  }

  void delete(int memberNo) {
    int index = indexOf(memberNo);

    if(index == -1)
      return;
    for (int x = index + 1; x < MemberList.size; x++) {
      MemberList.members[x-1] = MemberList.members[x];
    }
    MemberList.members[--MemberList.size] = null;
  }

  public boolean exist(String name) {
    for (int i = 0; i < MemberList.size; i++) {
      if (name.equals(MemberList.members[i].name)) {
        return true;
      }
    }
    return false;
  }

  int indexOf(int memberNo) {
    for (int i = 0; i < MemberList.size; i++) {
      Member member = MemberList.members[i];
      if (member.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

}
 */
