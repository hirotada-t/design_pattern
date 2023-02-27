package ToyKits.util;

import java.util.Arrays;
import ToyKits.util.constant.AllowedOrder;

public class Mini4WDOrder {
  protected String machineKey;
  protected int colorIndex;
  protected int rollers;
  protected boolean suspension;

  public Mini4WDOrder(String machineKey, int colorIndex) throws InvalidOrderException {
    if (!Arrays.asList(AllowedOrder.machineKey).contains(machineKey)) {
      throw new InvalidOrderException("Invalid machineKey: \n" + AllowedOrder.machineKeyString());
    }
    if (colorIndex < 0) {
      throw new InvalidOrderException("Invalid colorIndex: Only integers greater than or equal to zero are permitted.");
    }
    this.machineKey = machineKey;
    this.colorIndex = colorIndex;
  }

  public Mini4WDOrder(String machineKey, int colorIndex, int rollers, boolean suspension) throws InvalidOrderException {
    this(machineKey, colorIndex);
    if (rollers < 0 || rollers > 10) {
      throw new InvalidOrderException("Invalid num of rollers: The number of rollers must be zero or a positive one-digit number.");
    }
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
