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
/*interface Car{
    void changeColor(int newColor);
    void changeSpeed(int Newspeed);
    void changeGear(int Newgear);
}
class newCar implements Car{
    int color = 1 ;
    int speed = 2;
    int gear = 4;
    public void changeColor(int newValue) {
         color = newValue;
    }
    public void changeSpeed(int newValue) {
         speed = newValue;
    }
    public void changeGear(int newValue) {
         gear = newValue;
    //System.out.println( "color:"+ color );
    }
}

public class NewClass{
    int aNumber=3;
    public NewClass(int aNumber) {
       
    }
    public void main(String arg[]){
        if (aNumber >= 0)
        if (aNumber == 0) System.out.println("first string");
        else System.out.println("second string");
        System.out.println("third string");
    }
   
}*/
interface changeTree{
    void changeColor(String newColor);
    void changeHeight(int Newheight);
    void changeAge(int Newage);
}
class Tree{
    String color="green";
    int height=4;
    int age=20;
}

class YangShu extends Tree implements changeTree{
    public void changeColor(String newColor) {
        if (color.equals(newColor)){
            System.out.println(super.color);
        }
        else color = newColor;System.out.println("YangShu's colour="+color);
    }
    public void changeHeight(int newValue) {
        if (height!=newValue){
            System.out.println(newValue);
        }
        else System.out.println("YangShu's height="+this.height);
    }
    public void changeAge(int newValue) {
         age = newValue;
         System.out.println("YangShu's age="+age);
    //System.out.println( "color:"+ color );
    }
}








   
     
