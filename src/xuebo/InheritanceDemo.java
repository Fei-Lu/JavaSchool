/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

/**
 *
 * @author Xuebo Zhao
 */
class Animal{
   public void move(){
      System.out.println("Animal can move");
   }
}
 
class Dog extends Animal{
   public void move(){
      super.move(); 
      System.out.println("Dog can run and bark");
   }
}
abstract class AnimalDemo {  
    abstract void eat();  
}  
  
class Cat extends Animal {  
    public void eat() {  
        System.out.println("eat fish");  
    }  
    public void work() {  
        System.out.println("catch the mouse");  
    }  
}  
  
 