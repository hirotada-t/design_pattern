package ToyKits;

import ToyKits.util.CreateOrder;
import ToyKits.util.FairyWorld;

public class Main {
  public static void main(String[] args) {
    FairyWorld fairyWorld = new FairyWorld();
    CreateOrder order = new CreateOrder("normal", 10);
    fairyWorld.run("easy", order);
  }
}