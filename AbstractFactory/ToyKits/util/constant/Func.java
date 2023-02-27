package ToyKits.util.constant;

public class Func {
  public static String arrToString(String[] arr) {
    String str = "";
    for (int i = 0; i < arr.length; i++) {
      str += (" - " + arr[i] + "\n");
    }
    return str;
  }
}
