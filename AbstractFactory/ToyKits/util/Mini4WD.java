package ToyKits.util;

class Spec {
  protected int weightG;
  protected int costYen;
  protected double speed;

  public Spec(int weightG, int costYen) {
    this.weightG = weightG;
    this.costYen = costYen;
    this.speed = 0.0;
  }
}

class Structure {
  protected Parts body;
  protected Parts battery;

  public Structure(Parts body, Parts battery) {
    this.body = body;
    this.battery = battery;
  }
}

public class Mini4WD {
  protected Spec spec;
  protected Structure structure;

  public Mini4WD(Structure structure) {
    this.structure = structure;
  }

  public int getTotalCosts() {
    return 1;
  }

  public int getTotalWeight() {
    return 1;
  }
}

class NormalMini4WD extends Mini4WD {
  public NormalMini4WD(Structure structure) {
    super(structure);
  }
}

// Parts
class Parts {
  private int costYen;
  private int weightG;

  public Parts(int costYen, int weightG) {
    this.costYen = costYen;
    this.weightG = weightG;
  }

  public int getCost() {
    return this.costYen;
  }

  public int getWeight() {
    return this.weightG;
  }
}

class Body extends Parts {
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

class Battery extends Parts {
  public static final double POWER_W = 1.5;

  public Battery() {
    super(50, 25);
  }
}