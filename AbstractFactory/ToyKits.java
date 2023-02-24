import java.util.HashMap;

// Mini4WD
class Spec {
  protected int weightG;
  protected int costYen;
}

class Structore {
  protected Parts battery;
  
  public Structore() {}

}

class Mini4WD {
  protected Spec spec;
  protected Structore structore;

  public Mini4WD(Parts battery) {
    this.structore = new Structore();
    this.structore.battery = battery;
  }

  public int getTotalCosts() {
    return this.structore.battery.costYen;
  }
  
  public int getTotalWeight() {
    return this.structore.battery.weightG;
  }
}

class NormalMini4WD extends Mini4WD {
  public NormalMini4WD(Parts battery) {
    super(battery);
  }
}

// AbstractFactory
interface Mini4WDFactory {
  abstract public Mini4WD createMini4wd();
  abstract public Parts createBattery();
}

class NormalMini4WDFactory implements Mini4WDFactory {
  @Override
  public Mini4WD createMini4wd() {
    Parts battery = this.createBattery();
    return new NormalMini4WD(battery);
  }

  @Override
  public Parts createBattery() {
    return new Battery();
  }
}

// Parts
class Parts {
  protected int costYen;
  protected int weightG;

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

class Battery extends Parts {
  public static final double POWER_W = 1.5;

  public Battery() {
    super(50, 25);
  }
}

// Course
abstract class CourseAssistant {
  protected boolean laneChange;
  protected double upDown;
  protected int corner;
  
  protected CourseAssistant(boolean laneChange, double upDown, int corner) {
    this.laneChange = laneChange;
    this.upDown = upDown;
    this.corner = corner;
  }

  abstract public void raceMini4WD(Mini4WD machine);
}

class EasyCourse extends CourseAssistant {
  public EasyCourse() {
    super(false, 0, 4);
  }

  @Override
  public void raceMini4WD(Mini4WD machine) {
    System.out.println("easy");
  }
}

class FairyWorld {
  public HashMap<String, CourseAssistant> courseMap = new HashMap<>();
  public HashMap<String, Mini4WDFactory> mini4WDMap = new HashMap<>();

  public FairyWorld() {
    courseMap.put("easy", new EasyCourse());

    mini4WDMap.put("normal", new NormalMini4WDFactory());
  }

  public void run(String courseKey, String machineKey) {
    Mini4WD machine = mini4WDMap.get(machineKey).createMini4wd();
    this.courseMap.get(courseKey).raceMini4WD(machine);
    System.out.println("test-OK");
  }
}

class ToyKits {
  public static void main(String[] args) {
    FairyWorld fairyWorld = new FairyWorld();
    fairyWorld.run("easy", "normal");
  }
}