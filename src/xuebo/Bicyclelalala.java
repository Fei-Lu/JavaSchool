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
public class Bicyclelalala {
     int cadence = 0;
     int speed = 0;
     int gear = 1;
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
         System.out.println("cadence:"+
                 cadence + "speed:"+
                 speed + "gear:"+gear);
     }
}
class BicycleDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Bicyclelalala bike1 = new Bicyclelalala();
        Bicyclelalala bike2 = new Bicyclelalala();

        // Invoke methods on 
        // those objects
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.printStates();
    }
}