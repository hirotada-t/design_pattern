package ToyKits.util.constant;

public class AllowedOrder {
  public static final String[] machineKey = { "normal", "straight", "climb", "original" };
  public static final String[] chassisGrade = { "normal", "hard", "veryHard" };
  public static final String[] tyresType = { "normal", "soft", "hard" };

  public static String machineKeyString() {
    String str = "";
    for (int i = 0; i < AllowedOrder.machineKey.length; i++) {
      str += (" - " + AllowedOrder.machineKey[i] + "\n");
    }
    return str;
  }
}
