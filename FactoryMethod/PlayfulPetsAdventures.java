import java.util.Random;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

class RandomWrapper{
    public static double getRanDouble(double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public static boolean ranBoolean(){
        return new Random().nextBoolean();
    }
}

class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}

class BMI{
    private double heightM;
    private double weightKg;

    public BMI(double heightM, double weightKg){
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public double getWeightKg(){
        return this.weightKg;
    }

    public double getValue(){
        return this.weightKg/(this.heightM*this.heightM);
    }

    public String toString(){
        return this.heightM + " meters, " + this.weightKg + "kg, BMI:" + this.getValue();
    }
}

class Animal{
    protected String species;
    protected BMI bmi;
    protected double lifeSpanDays;
    protected String biologicalSex;
    protected Date spawnTime;
    protected Date deathTime;
    protected int hungerPercent = 100;
    protected int sleepPercent = 100;

    public Animal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex){
        this.species = species;
        this.bmi = new BMI(heightM, weightKg);
        this.lifeSpanDays = lifeSpanDays;
        this.biologicalSex = biologicalSex;
        this.spawnTime = new java.util.Date();
    }

    public void eat(){
        if(!this.isAlive()) return;
        this.hungerPercent = 0;
    }

    public void setAsHungry(){
        if(!this.isAlive()) return;
        this.hungerPercent = 100;
    }

    public boolean isHungry(){
        return this.hungerPercent >= 70;
    }

    public void sleep(){
        if(!this.isAlive()) return;
        this.sleepPercent = 0;
    }

    public void setAsSleepy(){
        if(!this.isAlive()) return;
        this.sleepPercent = 100;
    }

    public boolean isSleepy(){
        return this.sleepPercent >= 70;
    }

    public void die(){
        this.sleepPercent = 0;
        this.hungerPercent = 0;
        this.deathTime = new java.util.Date();
    }

    public boolean isAlive(){
        return this.deathTime == null;
    }

    public String toString(){
        return this.species + " " + this.bmi + " lives " + this.lifeSpanDays + " days/" + "gender:" + this.biologicalSex + "." + this.status();
    }

    public String status(){
        return this.species + " status:" + " Hunger - " + this.hungerPercent + "%, " + "sleepiness:"+this.sleepPercent + "%" + ", Alive - " + this.isAlive() + ". First created at " + this.dateCreated();
    }

    public String dateCreated(){
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(this.spawnTime);
    }
}

class Mammal extends Animal{
    private double bodyTemperatureC;
    private double avgBodyTemperatureC;

    public Mammal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double avgBodyTemperatureC){
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);

        this.avgBodyTemperatureC = avgBodyTemperatureC;
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }

    public void eat(){
        super.eat();
        System.out.println("this " + this.species + " is eating with its single lower jaw");
    }

    public String toString(){
        return super.toString() + " " + this.mammalInformation();
    }

    public void increaseBodyHeat(double celcius){
        this.bodyTemperatureC+=celcius;
    }

    public void decreaseBodyHeat(double celcius){
        this.bodyTemperatureC-=celcius;
    }

    public void adjustBodyHeat(){
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }

    public String mammalInformation(){
        return "This is a mammal with a temperature of: "+this.bodyTemperatureC;
    }
}

class Person extends Mammal{
    public static final String SPECIES = "Human";
    public static final double LIFE_EXPECTANCY = 30000;
    public static final double BODY_TEMPERATURE = 36;

    private Name name;
    private int age;

    public Person(String firstName, String lastName, int age, double heightM, double weightKg, String biologicalSex){
        super(Person.SPECIES, heightM, weightKg, Person.LIFE_EXPECTANCY, biologicalSex, Person.BODY_TEMPERATURE);
        this.name = new Name(firstName, lastName);
        this.age = age;
    }

    public String getGender() {
        return this.biologicalSex;
    }

    public String getName(){
        return this.name.toString();
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        return super.toString() + ". The name of this Person is " + this.getName();
    }
}

interface PlayfulPet{
    abstract public String play();
    abstract public String playWithPerson(Person person);
    abstract public String playNoise();
    abstract public String getPetName();
    abstract public double getRentalCosts();
    abstract public boolean likesActivity(String activity);
    abstract public boolean dislikesActivity(String activity);
    abstract public String doActivity(String activity);
}

abstract class PlayfulPetAssistant{
    protected static final double DEFAULT_RENT_TIME = 1.0;
    protected static final String DEFAULT_TOUR = "all-rounder pack";

    protected Person currentPerson;
    protected double currentRentTime = PlayfulPetAssistant.DEFAULT_RENT_TIME;
    protected static String[] availableActivities = {"eat","walk","drink","nap","pet","run","explore"};
    protected static String[] availableTours = {"all-rounder pack", "deluxe rounder pack"};

    public String[] getActivities(){
        return PlayfulPetAssistant.availableActivities;
    }

    public String[] getAvailableTours(){
        return PlayfulPetAssistant.availableTours;
    }

    public boolean isValidTour(String tour){
        return Arrays.asList(this.getAvailableTours()).contains(tour);
    }

    protected String getRandomActivity(){
        List<String> activities = Arrays.asList(this.getActivities());
        int ran = new Random().nextInt(activities.size());
        return activities.get(ran);
    }

    public void setPerson(Person person){
        this.currentPerson = person;
    }

    public void setHours(double hours){
        this.currentRentTime = hours;
    }

    public double getCurrentRentTime(){
        return this.currentRentTime;
    }

    public void reset(){
        this.currentPerson = null;
        this.currentRentTime = PlayfulPetAssistant.DEFAULT_RENT_TIME;
    }

    public double runAssistanceTour(Person person, int amount, String tour){
        if(!this.isValidTour(tour)) System.out.println("The tour guide does not accept the " + tour + " tour.");
        
        PlayfulPet playfulPet = this.createPlayfulPet();

        System.out.println("");
        System.out.println("Booting up... Playful Pet Assistance robot at your service.");
        System.out.println("Printing information about the Person to service..." + person);
        System.out.println("");
        System.out.println("Printing information about the Playful Pet - " + playfulPet.getPetName() + " to service..." + playfulPet);

        if(tour == "all-rounder pack" || tour == "deluxe rounder pack"){
            int count = tour == "all-rounder pack" ? 1 : 3;
            for (int i = 0; i < amount; i++) {
                this.genericRounderTour(count, person, playfulPet);
                System.out.println("     -----     ");
            }
        } else {
            System.out.println("The tour assistant robot for " + playfulPet.getPetName() + " and " + person.getName() + " did nothing.");
        }

        double rentalCosts = playfulPet.getRentalCosts() * this.getCurrentRentTime() * amount;

        this.reset();

        return rentalCosts;
    }

    private void genericRounderTour(int activityCount, Person person, PlayfulPet pet){
        String newLine = System.lineSeparator();
        System.out.println(newLine + "Now starting the generic rounder tour with " + activityCount + " activity(s)");
        System.out.println(person.getName() + " greets " + pet.getPetName() + newLine);
        System.out.println(pet.play() + newLine);
        System.out.println(pet.playNoise() + newLine);
        System.out.println(pet.playWithPerson(person) + newLine);
        for(int i = 0; i < activityCount; i++){
            String activity = this.getRandomActivity();
            System.out.println(pet.getPetName() + " will now " + activity);
            System.out.println("--------");
            System.out.println(pet.doActivity(activity));
            System.out.println("--------" + newLine);
        }
    }

    public abstract PlayfulPet createPlayfulPet();
}

class Cat extends Mammal implements PlayfulPet{
    public static final String SPECIES = "Cat";
    public static final double LIFE_EXPECTANCY = 5500;
    public static final double BODY_TEMPERATURE = 37;

    private static final double PLAYFUL_HOURLY_COSTS = 50;
    private static final String[] LIKED_ACTIVITIES = {"eat","nap","groom","drink","crawl","explore","pet"};
    private static final String[] DISLIKED_ACTIVITIES = {"bath"};

    public Cat(double heightM, double weightKg, String biologicalSex){
        super(Cat.SPECIES, heightM, weightKg, Cat.LIFE_EXPECTANCY, biologicalSex, Cat.BODY_TEMPERATURE);
    }

    public String toString(){
        return super.toString() + " this is a cat";
    }

    public void meow(){
        System.out.println("Meooow");
    }

    public String getPetName(){
        return this.species;
    }

    public String play(){
        return "This cat starts rolling on the floor, and pretends to play predator";
    }

    public String playWithPerson(Person person){
        String s = "The cat stares at " + person.getName();
        s+= ". After taking kin to " + person.getName() + ", " + person.getName() + " throws a mouse toy at this cat and the cat starts chasing the mouse toy";
        return s;
    }

    public String playNoise(){
        return "Meow";
    }

    public double getRentalCosts(){
        return Cat.PLAYFUL_HOURLY_COSTS;
    }

    public boolean likesActivity(String activity){
        return Arrays.asList(Cat.LIKED_ACTIVITIES).contains(activity);
    };

    public boolean dislikesActivity(String activity){
        return Arrays.asList(Cat.DISLIKED_ACTIVITIES).contains(activity);
    };

    public String doActivity(String activity){
        if(activity == "eat"){
            this.eat();
            return "The cat enjoyed eating food.";
        }
        else if(activity == "nap"){
            this.sleep();
            return "The cat took a good nap.";
        }
        else if(this.likesActivity(activity)) return "Meow. The cat really enjoyed the " + activity + " activity.";
        else if(this.likesActivity(activity)) return "The cat really hated the " + activity + " activity.";
        return "The cat felt indiferent about the " + activity + " activity.";
    };
}

class Dog extends Mammal implements PlayfulPet{
    public static final String SPECIES = "Dog";
    public static final double LIFE_EXPECTANCY = 4800;
    public static final double Body_TEMPERATURE = 39;
    
    private static final double PLAYFUL_HOURLY_COSTS = 35;
    private static final String[] LIKED_ACTIVITIES = {"eat","nap","chase","swim","drink","run","explore","pet"};
    private static final String[] DISLIKED_ACTIVITIES = {"hug","dressup"};

    public Dog(double heightM, double weightKg, String biologicalSex){
        super(Dog.SPECIES, heightM, weightKg, Dog.LIFE_EXPECTANCY, biologicalSex, Dog.LIFE_EXPECTANCY);
    }

    public String toString(){
        return super.toString() + " this is a dog";
    }

    public void woof(){
        System.out.println("Woof Woof");
    }

    public String getPetName(){
        return this.species;
    }

    public String play(){
        return "This dog starts running on the park and chases a ball.";
    }

    public String playWithPerson(Person person){
        String s = "The dog runs towards " + person.getName();
        s+= ". After the dog taking kin to " + person.getName() + ", " + person.getName() + " throws a frisbee disk and the dog chases it.";
        return s;
    }

    public String playNoise(){
        return "Wooooof Woooof";
    }

    public double getRentalCosts(){
        return Dog.PLAYFUL_HOURLY_COSTS;
    }

    public boolean likesActivity(String activity){
        return Arrays.asList(Dog.LIKED_ACTIVITIES).contains(activity);
    };

    public boolean dislikesActivity(String activity){
        return Arrays.asList(Dog.DISLIKED_ACTIVITIES).contains(activity);
    };

    public String doActivity(String activity){
        if(activity == "eat"){
            this.eat();
            return "The dog ate the entire food in a few bites.";
        }
        else if(activity == "nap"){
            this.sleep();
            return "The dog took a quick nap.";
        }
        else if(this.likesActivity(activity)) return "Woof Woof. The dog really enjoyed the " + activity + " activity.";
        else if(this.likesActivity(activity)) return "The dog did not like " + activity + " activity. The dog walked away";
        return "The dog felt indiferent about the " + activity + " activity.";
    };
}

class Rabbit extends Mammal implements PlayfulPet{
    public static final String SPECIES = "Rabbit";
    public static final double LIFE_EXPECTANCY = 3000;
    public static final double Body_TEMPERATURE = 40;
    
    private static final double PLAYFUL_HOURLY_COSTS = 30;
    private static final String[] LIKED_ACTIVITIES = {"eat","nap","chase","drink","jump","dig"};
    private static final String[] DISLIKED_ACTIVITIES = {"bath","dressup"};

    public Rabbit(double heightM, double weightKg, String biologicalSex){
        super(Rabbit.SPECIES, heightM, weightKg, Rabbit.LIFE_EXPECTANCY, biologicalSex, Rabbit.LIFE_EXPECTANCY);
    }

    public String toString(){
        return super.toString() + " this is a rabbit";
    }

    public void woof(){
        System.out.println("Squeak Squeak");
    }

    public String getPetName(){
        return this.species;
    }

    public String play(){
        return "This rabbit starts jumping around and chases an insect on the grass.";
    }

    public String playWithPerson(Person person){
        String s = "The bunny hops towards " + person.getName();
        s+= ". After the rabbit stares at " + person.getName() + ", " + person.getName() + " makes the rabbit chase a small carrot. The rabbit hops towards it.";
        return s;
    }

    public String playNoise(){
        return "Squeak";
    }

    public double getRentalCosts(){
        return Rabbit.PLAYFUL_HOURLY_COSTS;
    }

    public boolean likesActivity(String activity){
        return Arrays.asList(Rabbit.LIKED_ACTIVITIES).contains(activity);
    };

    public boolean dislikesActivity(String activity){
        return Arrays.asList(Rabbit.DISLIKED_ACTIVITIES).contains(activity);
    };

    public String doActivity(String activity){
        if(activity == "eat"){
            this.eat();
            return "The rabbit chew on the food bit by bit taking tiny bites.";
        }
        else if(activity == "nap"){
            this.sleep();
            return "The rabbit took a long nap.";
        }
        else if(this.likesActivity(activity)) return ".... The Rabbit really enjoyed the " + activity + " activity.";
        else if(this.likesActivity(activity)) return "Squeeeak. The Rabbit did not like " + activity + " activity. The rabbit quickly hopped away";
        return "The rabbit felt indiferent about the " + activity + " activity.";
    };
}

class PlayfulCatAssistant extends PlayfulPetAssistant{
    public PlayfulPet createPlayfulPet(){
        return new Cat(RandomWrapper.getRanDouble(0.15,0.3), RandomWrapper.getRanDouble(2.0,4.9), RandomWrapper.ranBoolean() ? "male" : "female");
    }
    // public abstract PlayfulPet createPlayfulPets(int amount) {
    // }
}

class PlayfulDogAssistant extends PlayfulPetAssistant{
    public PlayfulPet createPlayfulPet(){
        return new Dog(RandomWrapper.getRanDouble(0.15,1.3), RandomWrapper.getRanDouble(9.5,25.8), RandomWrapper.ranBoolean() ? "male" : "female");
    }
}

class PlayfulRabbitAssistant extends PlayfulPetAssistant{
    public PlayfulPet createPlayfulPet(){
        return new Rabbit(RandomWrapper.getRanDouble(0.15,0.4), RandomWrapper.getRanDouble(2.2,10.2), RandomWrapper.ranBoolean() ? "male" : "female");
    }
}

class Invoice {
    private String billTo;
    private String title;
    private HashMap<String, Double> rentedPets = new HashMap<>();
    private double totalBill;

    public Invoice(Person person) {
        this.billTo = person.getName();

        this.title = "Current invoice to";
        this.title += person.getGender() == "male" ? " Mr. ":" Ms. ";
        this.title += this.billTo + ".";

        this.totalBill = 0;
    }
    public String getTitle() {
        return this.title;
    }
    public HashMap<String, Double> getRentedPets() {
        return this.rentedPets;
    }
    public double getTotalBill() {
        return this.totalBill;
    }
    public void update(String pet, double costs) {
        this.rentedPets.put(pet, this.rentedPets.getOrDefault(pet, 0.0) + costs);
        this.totalBill += costs;
    }
}

class FairyWorld{
    private HashMap<String, PlayfulPetAssistant> robotList = new HashMap<>(){
        {
            put("cat", new PlayfulCatAssistant());
            put("dog", new PlayfulDogAssistant());
            put("rabbit", new PlayfulRabbitAssistant());
        }
    };
    private HashMap<String, Invoice> invoiceList = new HashMap<>();;

    public void getRentedPetsInvoice(Person person) {
        if (!invoiceList.containsKey(person.getName())) {
            String name = person.getGender() == "male" ? " Mr. ":" Ms. ";
            name += person.getName();
            System.out.println("No charges are made to " + name + ".");
        }
        Invoice invoice = invoiceList.get(person.getName());
        HashMap<String, Double> rentedPets = invoice.getRentedPets();
        System.out.println("("+ invoice.getTitle() +")");
        System.out.println("----------------- breakdown -------------------");
        for (Map.Entry<String, Double> entry : rentedPets.entrySet()) {
            System.out.println(" - " + entry.getKey() + " ........ " + entry.getValue() + " dollars");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("total ...... "+ invoice.getTotalBill() +" dollars" + System.lineSeparator());
    }

    public void addPlayfulPetAssistant(String key, PlayfulPetAssistant assistant) {
        this.robotList.put(key, assistant);
    }

    private boolean existPet(String petKey) {
        boolean res = robotList.containsKey(petKey.toLowerCase());
        if (!res) System.out.print("The pet cannot be rented.");
        return res;
    }

    public void rentPet(String petKey, Person person) {
        if (!this.existPet(petKey)) return;
        this.rentPet(petKey, person, 1, PlayfulPetAssistant.DEFAULT_TOUR);
    }
    
    public void rentPet(String petKey, Person person, int amount) {
        if (!this.existPet(petKey)) return;
        this.rentPet(petKey, person, amount, PlayfulPetAssistant.DEFAULT_TOUR);
    }
    
    public void rentPet(String petKey, Person person, String tour) {
        if (!this.existPet(petKey)) return;
        this.rentPet(petKey, person, 1, tour);
    }

    public void rentPet(String petKey, Person person, int amount, String tour) {
        if (!this.existPet(petKey)) return;
        String pet = petKey.toLowerCase();
        String name = person.getName();

        System.out.println("Thank you for your pet rental!");
        double costs = robotList.get(pet).runAssistanceTour(person, amount, tour);
        System.out.println(costs + " dollars were charged to " + name + "'s credit card.");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx" + System.lineSeparator());

        if (!invoiceList.containsKey(name)) invoiceList.put(name, new Invoice(person));
        invoiceList.get(name).update(pet, costs);
    }
}

class PlayfulPetsAdventures{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();
        Person jessica = new Person("Jessica", "Roller", 30, 1.65, 55, "female");
        Person eldred = new Person("Eldred", "Bradley", 42, 1.96, 126, "male");

        fairyWorld.rentPet("Dog", jessica, "deluxe rounder pack");
        fairyWorld.rentPet("Rabbit", jessica, 3);
        fairyWorld.rentPet("cat", jessica, 2);
        fairyWorld.getRentedPetsInvoice(jessica);
        fairyWorld.rentPet("cat", eldred);
        fairyWorld.getRentedPetsInvoice(eldred);
    }
}