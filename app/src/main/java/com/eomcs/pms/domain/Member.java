package com.eomcs.pms.domain;

import java.io.Serializable;

public class Member implements Serializable{

  private static final long serialVersionUID = 1L;
  public int no;
  public String name;
  public String nationality;
  public String position;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
    result = prime * result + no;
    result = prime * result + ((position == null) ? 0 : position.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (nationality == null) {
      if (other.nationality != null)
        return false;
    } else if (!nationality.equals(other.nationality))
      return false;
    if (no != other.no)
      return false;
    if (position == null) {
      if (other.position != null)
        return false;
    } else if (!position.equals(other.position))
      return false;
    return true;
  }
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
}
