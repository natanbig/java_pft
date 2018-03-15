package co.threads.examples;

/**
 * Created by natan.radostin on 3/15/2018.
 */
public class Main {
  public static void main(String[] args) {
    Thread t1 = new Thread(new Display("1"));
    t1.start();


  }


}
