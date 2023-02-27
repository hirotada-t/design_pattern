package ToyKits.util;

public class CreateOrder {
  protected String machineKey;
  protected int colorIndex;
  protected int rollers;
  protected boolean suspension;

  public CreateOrder(String machineKey, int colorIndex) {
    this.machineKey = machineKey;
    this.colorIndex = colorIndex;
  }

  public CreateOrder(String machineKey, int colorIndex, int rollers, boolean suspension) {
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
