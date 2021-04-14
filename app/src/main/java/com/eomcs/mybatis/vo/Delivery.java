package com.eomcs.mybatis.vo;

public class Delivery implements java.io.Serializable{

  private static final long serialVersionUID = 1L;

  public static final int DEFAULT_CAPACITY = 100;
  public static int size = 0;
  public String name;
  public String deliveryNo;
  public String sender;
  public String destinataire; 

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDeliveryNo() {
    return deliveryNo;
  }
  public void setDeliveryNo(String deliveryNo) {
    this.deliveryNo = deliveryNo;
  }
  public String getSender() {
    return sender;
  }
  public void setSender(String sender) {
    this.sender = sender;
  }
  public String getDestinataire() {
    return destinataire;
  }
  public void setDestinataire(String destinataire) {
    this.destinataire = destinataire;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((deliveryNo == null) ? 0 : deliveryNo.hashCode());
    result = prime * result + ((destinataire == null) ? 0 : destinataire.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((sender == null) ? 0 : sender.hashCode());
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
    Delivery other = (Delivery) obj;
    if (deliveryNo == null) {
      if (other.deliveryNo != null)
        return false;
    } else if (!deliveryNo.equals(other.deliveryNo))
      return false;
    if (destinataire == null) {
      if (other.destinataire != null)
        return false;
    } else if (!destinataire.equals(other.destinataire))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (sender == null) {
      if (other.sender != null)
        return false;
    } else if (!sender.equals(other.sender))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Delivery [name=" + name + ", deliveryNo=" + deliveryNo + ", sender=" + sender
        + ", destinataire=" + destinataire + "]";
  }

}
