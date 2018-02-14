package co.stqa.pft.sanbox;

/**
 * Created by natan.radostin on 2/11/2018.
 */
public class Square {

  public double l;

  public Square(double l){
    this.l = l;
  }
  public double area() {
    return this.l * this.l;
  }
}
