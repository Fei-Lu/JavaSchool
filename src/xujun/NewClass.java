/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xujun;

/**
 *
 * @author Jun Xu
 */
class Car {
    int color = 1 ;
    int speed = 2;
    int gear = 4;

    void changeColor(int newValue) {
         color = newValue;
    }
    //System.out.println( "color:"+ color );
}
class NewClass{
    public static void main (String[] args) {
        Car car1 = new Car();
        car1.changeColor(2);
        System.out.println("color:"+car1.color);
    }       
}
     
