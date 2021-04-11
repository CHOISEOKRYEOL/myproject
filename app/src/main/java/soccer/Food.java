package soccer;

import java.io.Serializable;

public class Food implements Serializable{

  private static final long serialVersionUID = 1L;
  public String name;
  public int carbohydrate;
  public int protein;
  public int calcium;
  public int fat;
  public int vitamin;


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + calcium;
    result = prime * result + carbohydrate;
    result = prime * result + fat;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + protein;
    result = prime * result + vitamin;
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
    Food other = (Food) obj;
    if (calcium != other.calcium)
      return false;
    if (carbohydrate != other.carbohydrate)
      return false;
    if (fat != other.fat)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (protein != other.protein)
      return false;
    if (vitamin != other.vitamin)
      return false;
    return true;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getCarbohydrate() {
    return carbohydrate;
  }
  public void setCarbohydrate(int carbohydrate) {
    if(carbohydrate < 0) {
      this.carbohydrate = 0;
      return;
    } else {
      this.carbohydrate = carbohydrate;
    }
  }
  public int getProtein() {
    return protein;
  }
  public void setProtein(int protein) {
    if(protein < 0) {
      this.protein = 0;
      return;
    } else {
      this.protein = protein;
    }
  }
  public int getCalcium() {
    return calcium;
  }
  public void setCalcium(int calcium) {
    if(calcium < 0) {
      this.calcium = 0;
      return;
    } else {
      this.calcium = calcium;
    }
  }
  public int getFat() {
    return fat;
  }
  public void setFat(int fat) {
    if(fat < 0) {
      this.fat = 0;
      return;
    } else {
      this.fat = fat;
    }

  }
  public int getVitamin() {
    return vitamin;
  }
  public void setVitamin(int vitamin) {
    if(vitamin < 0) {
      this.vitamin = 0;
      return;
    } else {
      this.vitamin = vitamin;
    }
  }


}
