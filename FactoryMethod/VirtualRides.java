import java.util.Map;
import java.util.HashMap;

class Physique {
    private double height;
    private double weight;

    public Physique(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public String toString() {
        return this.height + " M - " + this.weight + " Kg";
    }
}

interface Status {
}

class Person implements Status {
    private String firstName;
    private String lastName;
    private Physique physique;

    public Person(String firstName, String lastName, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.physique = new Physique(height, weight);
        System.out.println(this.toString());
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public double getHeight() {
        return this.physique.getHeight();
    }

    public double getWeight() {
        return this.physique.getWeight();
    }

    public String toString() {
        return "My name is " + this.getName() + "(" + this.physique.toString() + ").";
    }
}

interface Attraction {
    abstract public String getName();

    abstract public boolean heightLimit(Person person);
}

class JurassicPark implements Attraction {
    public static final String ATTRACTION_NAME = "Jurassic Park the Ride";

    public JurassicPark() {
    }

    public String getName() {
        return JurassicPark.ATTRACTION_NAME;
    }

    public boolean heightLimit(Person person) {
        return true;
    }
}

class Terminator2_3D implements Attraction {
    public static final String ATTRACTION_NAME = "Terminator 2:3D";

    public Terminator2_3D() {
    }

    public String getName() {
        return Terminator2_3D.ATTRACTION_NAME;
    }

    public boolean heightLimit(Person person) {
        return true;
    }
}

class FlightOfTheHippogriff implements Attraction {
    public static final String ATTRACTION_NAME = "Flight of the Hippogriff";
    public static final double MIN_HEIGHT = 1.22;
    public static final double MAX_HEIGHT = 1.95;

    public FlightOfTheHippogriff() {
    }

    public String getName() {
        return FlightOfTheHippogriff.ATTRACTION_NAME;
    }

    public boolean heightLimit(Person person) {
        double h = person.getHeight();
        return FlightOfTheHippogriff.MIN_HEIGHT < h && h < FlightOfTheHippogriff.MAX_HEIGHT;
    }
}

abstract class RideExperience {
    public void runAttraction(Person person) {
        Attraction attraction = this.createAttraction();
        if (!attraction.heightLimit(person)) {
            System.out.println("Cannot use " + attraction.getName() + ". You do not meet the height limit.");
            return;
        }
        System.out.println(attraction.getName() + " done!");
    }

    abstract public Attraction createAttraction();
}

class RideJurassicPark extends RideExperience {
    public Attraction createAttraction() {
        return new JurassicPark();
    }
}

class RideTerminator2_3D extends RideExperience {
    public Attraction createAttraction() {
        return new Terminator2_3D();
    }
}

class RideFlightOfTheHippogriff extends RideExperience {
    public Attraction createAttraction() {
        return new FlightOfTheHippogriff();
    }
}

class FairyWorld {
    private HashMap<String, RideExperience> attractionList = new HashMap<>();

    public FairyWorld() {
        this.attractionList.put("jurassic park", new RideJurassicPark());
        this.attractionList.put("terminator", new RideTerminator2_3D());
        this.attractionList.put("hippogriff", new RideFlightOfTheHippogriff());
    }

    public void getAttractionList() {
        System.out.println("-----(Attraction List)-----");
        for (Map.Entry<String, RideExperience> entry : this.attractionList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("---------------------------");
    }

    public void ride(Person person, String key) {
        this.attractionList.get(key).runAttraction(person);
    }
}

class VirtualRides {
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();
        Person araisan = new Person("Arai", "Takahiro", 1.89, 102.5);
        Person jessica = new Person("Jessica", "Roller", 1.20, 30.5);

        fairyWorld.getAttractionList();

        fairyWorld.ride(araisan, "jurassic park");
        fairyWorld.ride(araisan, "terminator");
        fairyWorld.ride(araisan, "hippogriff");
        System.out.println("----------");
        fairyWorld.ride(jessica, "jurassic park");
        fairyWorld.ride(jessica, "terminator");
        fairyWorld.ride(jessica, "hippogriff");
    }
}