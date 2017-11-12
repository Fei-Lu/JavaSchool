/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;

/**
 *
 * @author cauxu
 */
public class Car {
    int speed;
    int[] colour={'r','e','d'};
    public void changeSpeed(int s){
        speed=s+100;
        System.out.println(speed);
    }
    public void changeColour(int[] c){
        colour=c;
        System.out.println(colour);
    }
    
}
