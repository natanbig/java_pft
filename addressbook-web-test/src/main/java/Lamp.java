/**
 * Created by natan.radostin on 3/7/2018.
 */
public class Lamp implements ElectricityConsumer {
  public void lightOn(){
    System.out.println("Лампа зажглась");
  }

  @Override
  public void electricityOn(Object sender) {
    lightOn();
  }
}
