package ToyKits;

import ToyKits.util.Mini4WDOrder;
import ToyKits.util.FairyWorld;
import ToyKits.util.InvalidOrderException;

public class Main {
  public static void main(String[] args) {
    FairyWorld fairyWorld = new FairyWorld();
    try {
      Mini4WDOrder order = new Mini4WDOrder("normal", 10, 1, false);
      fairyWorld.run("easy", order);
    } catch (InvalidOrderException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }
}