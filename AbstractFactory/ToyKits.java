import java.util.HashMap;

// Mini4WD
class Spec {
  private int weightG;
  private int costYen;
  private double speed;
  
  public Spec(int weightG, int costYen) {
    this.weightG = weightG;
    this.costYen = costYen;
    this.speed = 0.0;
  }
}

class Structure {
  private Parts body;
  private Parts battery;
  
  public Structure(Parts body, Parts battery) {
    this.body = body;
    this.battery = battery;
  }
}

class CreateOrder {
  private String machineKey;
  private int colorIndex;
  private int rollers;
  private boolean suspension;
  
  public CreateOrder(String machineKey,int colorIndex) {
    this.machineKey = machineKey;
    this.colorIndex = colorIndex;
  }
  
  public CreateOrder(String machineKey,int colorIndex, int rollers, boolean suspension) {
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

class Mini4WD {
  private Spec spec;
  private Structure structure;

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

// AbstractFactory
interface Mini4WDFactory {
  abstract public Structure createStructure(CreateOrder order);
  abstract public Mini4WD createMini4WD(CreateOrder order);
  abstract public Parts createBody(CreateOrder order);
  abstract public Parts createBattery();
}

class NormalMini4WDFactory implements Mini4WDFactory {
  @Override
  public Structure createStructure(CreateOrder order) {
    Parts body = this.createBody(order);
    Parts battery = this.createBattery();  
    return new Structure(body, battery);
  }
  @Override
  public Mini4WD createMini4WD(CreateOrder order) {
    Structure structure = this.createStructure(order);
    return new NormalMini4WD(structure);
  }
  
  @Override
  public Parts createBody(CreateOrder order) {
    return new Body(order.getColorIndex());
  }

  @Override
  public Parts createBattery() {
    return new Battery();
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
    "red","blue","green","black","yellow","pink"
  };

  private String color;
  
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

// Course
abstract class CourseAssistant {
  private boolean laneChange;
  private double upDown;
  private int corner;
  
  public CourseAssistant(boolean laneChange, double upDown, int corner) {
    this.laneChange = laneChange;
    this.upDown = upDown;
    this.corner = corner;
  }

  abstract public void race(Mini4WD machine);
}

class EasyCourse extends CourseAssistant {
  public EasyCourse() {
    super(false, 0, 4);
  }

  @Override
  public void race(Mini4WD machine) {
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

  public void run(String courseKey, CreateOrder order) {
    Mini4WD machine = mini4WDMap.get(order.getMachineKey()).createMini4WD(order);
    this.courseMap.get(courseKey).race(machine);
    System.out.println("test-OK");
  }
}

class ToyKits {
  public static void main(String[] args) {
    FairyWorld fairyWorld = new FairyWorld();
    CreateOrder order = new CreateOrder("normal", 10);
    fairyWorld.run("easy", order);
  }
}