package com.eomcs.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Training implements Serializable{

  private static final long serialVersionUID = 1L;
  public String name;
  public String title;
  public String content;
  public Date sdt;
  public Date edt;
  public int status;
  public String stateLabel;

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
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getSdt() {
    return sdt;
  }
  public void setSdt(Date sdt) {
    this.sdt = sdt;
  }
  public Date getEdt() {
    return edt;
  }
  public void setEdt(Date edt) {
    this.edt = edt;
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
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((edt == null) ? 0 : edt.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
    result = prime * result + ((stateLabel == null) ? 0 : stateLabel.hashCode());
    result = prime * result + status;
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
    Training other = (Training) obj;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (edt == null) {
      if (other.edt != null)
        return false;
    } else if (!edt.equals(other.edt))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (sdt == null) {
      if (other.sdt != null)
        return false;
    } else if (!sdt.equals(other.sdt))
      return false;
    if (stateLabel == null) {
      if (other.stateLabel != null)
        return false;
    } else if (!stateLabel.equals(other.stateLabel))
      return false;
    if (status != other.status)
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
    return "Training [name=" + name + ", title=" + title + ", content=" + content + ", sdt=" + sdt
        + ", edt=" + edt + ", status=" + status + ", stateLabel=" + stateLabel + "]";
  }

}
