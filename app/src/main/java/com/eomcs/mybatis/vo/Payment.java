package com.eomcs.mybatis.vo;

import java.io.Serializable;

public class Payment implements Serializable{

  private static final long serialVersionUID = 1L;
  public int no;
  public String name;
  public String title;
  public String price;
  public String cardNumber;
  public String tel;
  public String id;
  public int status;
  public String stateLabel;

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
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }
  public String getCardnumber() {
    return cardNumber;
  }
  public void setCardnumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getStateLabel() {
    return stateLabel;
  }
  public void setStateLabel(String stateLabel) {
    this.stateLabel = stateLabel;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + no;
    result = prime * result + ((price == null) ? 0 : price.hashCode());
    result = prime * result + ((stateLabel == null) ? 0 : stateLabel.hashCode());
    result = prime * result + status;
    result = prime * result + ((tel == null) ? 0 : tel.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
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
    Payment other = (Payment) obj;
    if (cardNumber == null) {
      if (other.cardNumber != null)
        return false;
    } else if (!cardNumber.equals(other.cardNumber))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (no != other.no)
      return false;
    if (price == null) {
      if (other.price != null)
        return false;
    } else if (!price.equals(other.price))
      return false;
    if (stateLabel == null) {
      if (other.stateLabel != null)
        return false;
    } else if (!stateLabel.equals(other.stateLabel))
      return false;
    if (status != other.status)
      return false;
    if (tel == null) {
      if (other.tel != null)
        return false;
    } else if (!tel.equals(other.tel))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "PayMent [no=" + no + ", name=" + name + ", title=" + title + ", price=" + price
        + ", cardNumber=" + cardNumber + ", tel=" + tel + ", id=" + id + ", status=" + status
        + ", stateLabel=" + stateLabel + "]";
  }

}
