import static java.lang.System.out;

/**
 * Created by natan.radostin on 3/7/2018.
 */
public class Program {
  public static void fire(Object sender){
    out.println("Fire");
  }
  public static void main(String[] args) {
    Switcher sw = new Switcher();
    Lamp lamp = new Lamp();
    Radio radio= new Radio();
    sw.addElectricityListener(lamp);
    sw.addElectricityListener(radio);

  sw.addElectricityListener(
          new ElectricityConsumer() {
            public void electricityOn(Object sender) {
              out.print("Fire");
            }
          }
  );





    //sw.addElectricityListener(sender->System.out.println("Пожар!!!"));
    sw.addElectricityListener(Program::fire);
    sw.switchOn();
  }
}
