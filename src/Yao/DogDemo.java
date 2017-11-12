/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yao;

/**
 *
 * @author yaozhou
 */
class Dog {
    String Name = "Naughty";
    String Color = "White";
    String breed = "Smoyed";
    boolean hungry = true;
    boolean toy = true;
    boolean food = true;
    void Barking(boolean newHungry){
        if (newHungry){
            System.out.println("Barking as to hungry");
        }
    }
    void Feching(boolean newToy){
        if (newToy){
            System.out.println("Barking as to hungry");
        }
    }
    void WaggingTail(boolean newFood){
       if (newFood){
            System.out.println("Feching for food");
        } 
    }
}
interface DogInter{
    void Barking(boolean newHungry);
    void Feching(boolean newToy);
    void WaggingTail(boolean newFood); 
}
class SamDog implements DogInter{
    String Name = "Naughty";
    String Color = "White";
    String breed = "Smoyed";
    boolean hungry = true;
    boolean toy = true;
    boolean food = true;
    // public for the Barking and other method (override)
    public void Barking(boolean newHungry){
        if (newHungry){
            System.out.println("Barking as to hungry");
        }
    }
    public void Feching( boolean newToy){
        if (newToy){
            System.out.println("Barking as to hungry");
        }
    }
    public void WaggingTail(boolean newFood){
       if (newFood){
            System.out.println("Feching for food");
        } 
    }
    
}
public class DogDemo{
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args){
       /*
       Dog dog1 = new Dog();
       Dog dog2 = new Dog();
       dog1.Barking(true);
       dog1.Feching(false);
       dog2.WaggingTail(true);
*/
       //excise Day02
       System.out.println("Day02:");
       SamDog dog1 = new SamDog();
       SamDog dog2 = new SamDog();
       dog1.Barking(true);
       dog1.Feching(false);
       dog2.WaggingTail(true);
       
       // excise Day03
        System.out.println("\nDay03:");
        int a = 0;
        boolean b = false;
        char c = 0; // change =0 , 1, 10 to see difference
        String d = "testing";
        byte e = 127; // change =0, 10, 010
        short f = 1;
        long g = 100;
        float h = 0; // chage 0, 1.0
        double i = 0.01;
        e = (byte)(e + 1);
        System.out.println("a = "+a+"\tb = " + b+"\tc = "+c+"\td = "+
            d+"\te = "+ e +"\nf = "+ f + "\tg = " + g +"\th = "+ h
        +"\ti = "+i);
        int aNumber = 0;
        if (aNumber >= 0)
            if (aNumber == 0)
                System.out.println("first string");
            else
                System.out.println("second string");
        System.out.println("third string");
        
    } 
}
