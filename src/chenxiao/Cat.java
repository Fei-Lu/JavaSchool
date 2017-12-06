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
public class Cat extends Animal{
     public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
     @Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

}
