package ToyKits;

import ToyKits.util.Mini4WDOrder;
import ToyKits.util.FairyWorld;

public class Main {
  public static void main(String[] args) {
    FairyWorld fairyWorld = new FairyWorld();
    Mini4WDOrder order = new Mini4WDOrder("normal", 10);
    fairyWorld.run("easy", order);
  }
}