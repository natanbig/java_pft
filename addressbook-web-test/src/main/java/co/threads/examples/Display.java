package co.threads.examples;

/**
 * Created by natan.radostin on 3/15/2018.
 */


public class Display implements Runnable {

  private String printString;

  public Display(String printString){
    this.printString=printString;
  }
  @Override
  public void run() {
    System.out.printf("Thread %s is going to sleep", printString);
    try{
        Thread.sleep(500);
    }catch (Exception e){}
    System.out.printf("Thread %s is wakeuping", printString);
  }
}
