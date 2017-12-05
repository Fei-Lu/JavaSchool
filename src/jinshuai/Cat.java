/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;

/**
 *
 * @author 靳帅
 */
public class Cat extends Animal{
    /*静态方法被隐藏*/
     public static void testClassMethod(){
                     System.out.println("Cat中的静态方法");}
     
     
     @Override
              public void testInstanceMethod(){
                     System.out.println("Cat中的实例方法");}
              
              
    
    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
