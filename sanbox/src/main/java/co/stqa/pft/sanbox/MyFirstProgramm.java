package co.stqa.pft.sanbox;

public class MyFirstProgramm {
  public static void main(String[] args)
  {
    Square s = new Square(5);
    System.out.println("Square surface " +s.l+"="+s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Rectangular surface " +r.a+" and "+ r.b+"="+r.area());


  }

}