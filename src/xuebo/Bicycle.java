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
}
class Mountainabike extends Bicycle{
    //new fields and methods defining
    //a mountain bike would go here
    public int seatHeight;
    public Mountainabike(int startCadence, int startSpeed, int startGear, int startHeight) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    } 
}
 

    




