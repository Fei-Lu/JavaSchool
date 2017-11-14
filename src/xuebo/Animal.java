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
//public class MyOuterClassDemo{
//    private int myVar = 1;
////inner class definition
//    class MyInnerClassDemo{
//        public void seeOuter(){
//            System.out.println("Value of myVar is :" + myVar);
//        }
//    }
//    //close inner class definition
//    void innerInstance(){
//        MyInnerClassDemo inner = new MyInnerClassDemo();
//        inner.seeOuter();
//    }
// }  
////close Top level class definition


////Top level class definition
//class MyOuterClassDemo{
//    private int x = 1;
//    public void diThings(){
//        String name  = "local variable"; //name is effectively final
//        //inner class defined inside a method of outer class
//        class MyInnerClassDemo{
//            public void seeOuter(){
//                System.out.println("Outer Value of x is :" + x);
//                System.out.println("Value of name is :" + name);
//            }//close inner class method
//        }//close inner class definition
//        MyInnerClassDemo inner = new MyInnerClassDemo();
//        inner.seeOuter();
//    }
//}
public class Animal{      //abstract,latering all motifited abstarct 
    public void play(){
        
    }
}
class Person{
    public static void main(String[] args){
        Animal d = new Animal(){
            public void play(){
                    System.out.println("play with hunman");
            }
        };//匿名类
        d.play();   
    }
}
