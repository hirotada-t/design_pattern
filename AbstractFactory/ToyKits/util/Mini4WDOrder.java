package ToyKits.util;

public class Mini4WDOrder {
  protected String machineKey;
  protected int colorIndex;
  protected int rollers;
  protected boolean suspension;

  public Mini4WDOrder(String machineKey, int colorIndex) {
    this.machineKey = machineKey;
    this.colorIndex = colorIndex;
  }

  public Mini4WDOrder(String machineKey, int colorIndex, int rollers, boolean suspension) {
    this(machineKey, colorIndex);
    this.rollers = rollers;
    this.suspension = suspension;
  }

  public String getMachineKey() {
    return this.machineKey;
  }

  public int getColorIndex() {
    return this.colorIndex;
  }
}
