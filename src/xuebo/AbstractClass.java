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
abstract class Animallala {  
    abstract void eat();  
}  
  
class Catmimi extends Animallala {  
    public void eat() {  
        System.out.println("eat fish");  
    }  
    public void work() {  
        System.out.println("catch the mouse");  
    }  
}  
  
class Dogwangwang extends Animallala {  
    public void eat() {  
        System.out.println("eat meat");  
    }  
    public void work() {  
        System.out.println("keeping the house");  
    }  
} 

public class AbstractClass {
    public static void main(String[] args) {
      show(new Catmimi());  
      show(new Dogwangwang());  
      Animallala a = new Catmimi();   
      a.eat();               
      Catmimi c = (Catmimi)a;         
      c.work();        
  }  
     public static void show(Animallala a)  {
      a.eat();  
        if (a instanceof Catmimi)  { 
            Catmimi c = (Catmimi)a;  
            c.work();  
        } else if (a instanceof Dogwangwang) { 
            Dogwangwang c = (Dogwangwang)a;  
            c.work();  
        }  
    }  
}
