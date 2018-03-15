/**
 * Created by natan.radostin on 3/8/2018.
 */
public class Radio implements ElectricityConsumer{
  public void playMusic(){
    System.out.println("Радио заиграло");
  }


  @Override
  public void electricityOn(Object sender) {
    playMusic();
  }
}
