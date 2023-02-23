class Person {
  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  public String toString() {
    return "My name is " + this.getName() + "(" + this.age + ") .";
  }
}

// parts interface
interface Product {
  public int getCosts();
}

// General parts class
// head
// body
// armss
// legs
// eyes
// hands
// feet

// CyberVampire parts class
// head
// body
// armss
// legs
// eyes
// hands
// feet

// UnderworldCerberus parts class
// head
// body
// armss
// legs
// eyes
// hands
// feet

// AbstractFactory
interface HumanoidToyKitFactory {
  // FactoryMethod
  // head
  // body
  // armss
  // legs
  // eyes
  // hands
  // feet
}

// CreationMethod
class CyberVampire implements HumanoidToyKitFactory {
}

class UnderworldCerberus implements HumanoidToyKitFactory {
}

class FairyWorld {
  public void createHumanoidToyByKit(HumanoidToyKitFactory factory) {}
}

class ToyKits {
  public static void main(String[] args) {
    Person child = new Person("seiya", "suzuki", 5);
    Person adult = new Person("masato", "morishita", 25);

    System.out.println(child);
    System.out.println(adult);
  }
}