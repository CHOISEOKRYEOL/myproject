package com.eomcs.mybatis;

import java.io.Serializable;

public class Member implements Serializable {

  private static final long serialVersionUID = 1L;
  public String name;
  public String nationality;
  public String position;

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
