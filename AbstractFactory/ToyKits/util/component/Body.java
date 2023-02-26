package ToyKits.util.component;

public class Body extends Parts {
  public static final double POWER_W = 1.5;
  public static final String[] COLOR_LIST = {
      "red", "blue", "green", "black", "yellow", "pink"
  };

  protected String color;

  public Body(int index) {
    super(150, 30);
    int len = Body.COLOR_LIST.length;
    this.color = Body.COLOR_LIST[index % len];
  }
}
