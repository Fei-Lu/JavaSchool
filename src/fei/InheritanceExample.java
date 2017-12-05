/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

/**
 *
 * @author feilu
 */
public class InheritanceExample {
    
    public InheritanceExample () {
        castTest();
        staticOverrideTest();
        defaultMethodTest1();
        defaultMethodTest2();
        
        
        
    }
    
    void defaultMethodTest2 () {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
        
        
        System.out.println(myApp.toString());
    }
    
    void defaultMethodTest1 () {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
    
    void staticOverrideTest () {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
    
    void castTest () {
        Bicycle b = new Bicycle();
        Object obj = (Object)b;
        
        //runtime error
        //MountainBike mb = (MountainBike) obj;
        
        if (obj instanceof MountainBike) {
            System.out.println("Yes, MountainBike");
        }
        
        if (obj instanceof Bicycle) {
            System.out.println("Yes, Bicycle");
        }
    }
}

interface Animall {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}
interface EggLayer extends Animall {
    @Override
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}
interface FireBreather extends Animall { }
class Dragon implements EggLayer, Animall {
    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}

class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}
interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}
interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}
class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}

class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}

class Bicycle {
        
    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;
    
    public Bicycle () {
        System.out.println("Initilizing a Bicycle with no parameters");
    }
    
    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
        
    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
        
}

class MountainBike extends Bicycle {
    
    public MountainBike () {
        super();
    }
        
    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }   
        
    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }   
}


