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
class Fruits {
    String Name = "Sweet";
    String Color = "Red";
    boolean taste = true;
    boolean beautiful = true;
    void Letmetaste(boolean newTaste){
        if (newTaste){
            System.out.println("Delicious");
        }
    }
    void Letmesee(boolean newBeautiful){
        if(newBeautiful){
            System.out.println("Very nice");
        }
    }

}
public class FruitsDemo{
    public static void main(String[] args){
        System.out.println("JavaSchoolDay03:");
        Fruits apple1 = new Fruits();
        Fruits apple2 = new Fruits();
        apple1.Letmetaste(true);
        apple2.Letmesee(true); 
    }
}
