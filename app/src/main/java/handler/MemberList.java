package handler;

public class MemberList {

  static final int DEFAULT_CAPACITY = 100;
  static int size = 0;
  static MemberList[] members = new MemberList[DEFAULT_CAPACITY];

  private static final long serialVersionUID = 1L;
  public int no;
  public String name;
  public String nationality;
  public String position;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getNationality() {
    return nationality;
  }
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }

  public void add(MemberList m) {
    members[size++] =  m;
  }


  public MemberList[] toArray() {
    MemberList[] arr = new MemberList[size];
    for(int i = 0; i < size; i++) {
      arr[i] = members[i];
    }
    return arr;
  }

  public MemberList get(int memberNo) {
    int i = indexOf(memberNo);
    if(i == -1)
      return null;
    return members[i];
  }

  void delete(int memberNo) {
    int index = indexOf(memberNo);

    if(index == -1)
      return;
    for (int x = index + 1; x < this.size; x++) {
      this.members[x-1] = this.members[x];
    }
    this.members[--this.size] = null;
  }

  public boolean exist(String name) {
    for (int i = 0; i < this.size; i++) {
      if (name.equals(this.members[i].name)) {
        return true;
      }
    }
    return false;
  }

  int indexOf(int memberNo) {
    for (int i = 0; i < this.size; i++) {
      MemberList member = this.members[i];
      if (member.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

}
