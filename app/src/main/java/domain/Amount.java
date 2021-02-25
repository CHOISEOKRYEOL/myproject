package domain;

public class Amount implements java.io.Serializable{

  private static final long serialVersionUID = 1L;

  public int number;
  public int fowardprice;
  public int midfielderprice;
  public int defenderprice;
  public int getNumber() {
    return number;
  }
  public void setNumber(int number) {
    this.number = number;
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


}
