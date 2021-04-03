package com.eomcs.mybatis.vo;

public class Amount implements java.io.Serializable{

  private static final long serialVersionUID = 1L;

  public static final int DEFAULT_CAPACITY = 100;
  public static int size = 0;
  public String name;
  public String scoutname;
  public int fowardprice;
  public int midfielderprice;
  public int defenderprice;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getScoutname() {
    return scoutname;
  }
  public void setScoutname(String scoutname) {
    this.scoutname = scoutname;
  }
  public int getFowardprice() {
    return fowardprice;
  }
  public void setFowardprice(int fowardprice) {
    this.fowardprice = fowardprice;
  }
  public int getMidfielderprice() {
    return midfielderprice;
  }
  public void setMidfielderprice(int midfielderprice) {
    this.midfielderprice = midfielderprice;
  }
  public int getDefenderprice() {
    return defenderprice;
  }
  public void setDefenderprice(int defenderprice) {
    this.defenderprice = defenderprice;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + defenderprice;
    result = prime * result + fowardprice;
    result = prime * result + midfielderprice;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((scoutname == null) ? 0 : scoutname.hashCode());
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
    Amount other = (Amount) obj;
    if (defenderprice != other.defenderprice)
      return false;
    if (fowardprice != other.fowardprice)
      return false;
    if (midfielderprice != other.midfielderprice)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (scoutname == null) {
      if (other.scoutname != null)
        return false;
    } else if (!scoutname.equals(other.scoutname))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Amount [name=" + name + ", scoutname=" + scoutname + ", fowardprice=" + fowardprice
        + ", midfielderprice=" + midfielderprice + ", defenderprice=" + defenderprice + "]";
  }


}
