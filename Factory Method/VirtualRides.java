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

interface Status {}

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
    public String toString() {
        return "My name is " + this.getName() + "(" + this.physique.toString() + ").";
    }
}

interface Attraction {
    abstract public String getName();
}

class JurassicPark implements Attraction {
    public static final String ATTRACTION_NAME = "JurassicPark";
    public static final double MAX_WEIGHT = 200;
    public static final double MIN_HEIGHT = 0;
    public static final double MAX_HEIGHT = 300;

    public JurassicPark() {
    }

    public String getName() {
        return this.ATTRACTION_NAME;
    }
}

class Terminator2_3D implements Attraction {
    public static final String ATTRACTION_NAME = "Terminator2_3D";
    public static final double MAX_WEIGHT = 200;
    public static final double MIN_HEIGHT = 0;
    public static final double MAX_HEIGHT = 300;

    public Terminator2_3D() {
    }

    public String getName() {
        return this.ATTRACTION_NAME;
    }
} 

class FlightOfTheHippogriff implements Attraction {
    public static final String ATTRACTION_NAME = "FlightOfTheHippogriff";
    public static final double MAX_WEIGHT = 200;
    public static final double MIN_HEIGHT = 1.22;
    public static final double MAX_HEIGHT = 1.95;

    public FlightOfTheHippogriff() {
    }

    public String getName() {
        return this.ATTRACTION_NAME;
    }
} 

abstract class RideExperience {
    public void runAttraction() {
        Attraction attraction = this.createAttraction();
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
        for (Map.Entry<String, RideExperience> entry: this.attractionList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("----------------------------------");
    }

    public void ride(Person personk, String key) {
        this.attractionList.get(key).runAttraction();
    }
}

public class VirtualRides{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();
        Person player = new Person("Arai", "Takahiro", 1.89, 102.5);

        fairyWorld.getAttractionList();

        fairyWorld.ride(player, "jurassic park");
        fairyWorld.ride(player, "terminator");
        fairyWorld.ride(player, "hippogriff");
    }
}