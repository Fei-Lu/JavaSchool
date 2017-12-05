/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

/**
 *
 * @author xuebo
 */
public class Bicycle {
//    field
    public int cadence;
    public int gear;
    public int speed;
//constructor
public Bicycle(int startCadence, int startSpeed, int startGear){
    gear = startGear;
    cadence = startCadence;
    speed = startSpeed;
}
    void changeCadence(int newValue){
         cadence = newValue;
     }
     void changeGear(int newValue){
         gear = newValue;
     }
     void speedUp(int increment){
         speed = speed + increment;
     }
     void applyBrakes(int decrement){
         speed = speed - decrement;
     }
     void printStates(){
         System.out.println("cadence:"+ cadence);
         System.out.println ("speed:" + speed);
         System.out.println ("gear:"+ gear);
     }
    void printDescription(){
    System.out.println("\nBike is " + "in gear " + this.gear
        + " with a cadence of " + this.cadence +
        " and travelling at a speed of " + this.speed + ". ");
    }
}
class RoadBike extends Bicycle{
    private int tireWidth;
    public RoadBike(int startCadence,
                    int startSpeed,
                    int startGear,
                    int newTireWidth){
        super(startCadence,
              startSpeed,
              startGear);
        this.setTireWidth(newTireWidth);
    }
    public int getTireWidth(){
      return this.tireWidth;
    }
    public void setTireWidth(int newTireWidth){
        this.tireWidth = newTireWidth;
    }
    public void printDescription(){
        super.printDescription();
        System.out.println("The RoadBike" + " has " + getTireWidth() +
            " MM tires.");
    }
}
class MountainBike extends Bicycle {
    private String suspension;
    public MountainBike(
               int startCadence,
               int startSpeed,
               int startGear,
               String suspensionType){
        super(startCadence,
              startSpeed,
              startGear);
        this.setSuspension(suspensionType);
    }
    public String getSuspension(){
      return this.suspension;
    }
    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }
    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "MountainBike has a" +
            getSuspension() + " suspension.");
    }
} 
 class TestBikes {
  public static void main(String[] args){
    Bicycle bike01, bike02, bike03;

    bike01 = new Bicycle(20, 10, 1);
    bike02 = new MountainBike(20, 10, 5, "Dual");
    bike03 = new RoadBike(40, 20, 8, 23);

    bike01.printDescription();
    bike02.printDescription();
    bike03.printDescription();
  }
}

    




