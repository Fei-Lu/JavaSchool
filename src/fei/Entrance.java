/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

/**
 *
 * @author feilu
 */
public class Entrance {
    
    public Entrance () {
        this.ClassAndObjects();
    }
    
    public void ClassAndObjects () {
        /*******Nested class*********/
        //NestedClassExample nce = new NestedClassExample ();
        
        /*********Local class******************/
        //LocalClassExample.validatePhoneNumber("123-456-7890", "456-7890");
        
        /************Anonymous class*************************/
        //AnonymousClassExample ace = new AnonymousClassExample();
        //ace.sayHello();
        //Set main to run GUIHelloWorld.
        //Set main to run CustomTextFieldSample.
        
        /****************Lambda expression**********************/
        //LambdaExpressionExample.tests();
        
        /*******************Method reference****************************/
        new MethodReferencesTest().printPerson();
        
        
    }
    
    public static void main (String[] args) {
        new Entrance ();
        
    }

}
