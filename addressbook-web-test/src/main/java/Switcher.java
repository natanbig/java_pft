import java.util.ArrayList;
import java.util.List;

/**
 * Created by natan.radostin on 3/7/2018.
 */
public class Switcher {
  private List<ElectricityConsumer> lesteners = new ArrayList<>();

  public void addElectricityListener(ElectricityConsumer listener){
    lesteners.add(listener);
  }

  public void removeElectricityListener(ElectricityConsumer listener){
    lesteners.remove(listener);
  }

  public  void switchOn(){
    System.out.println("Выключатель включен");
//    if(consumer!=null)
  //    consumer.electricityOn();
    for(ElectricityConsumer c:lesteners){
      c.electricityOn(this);
    }

  }
}
