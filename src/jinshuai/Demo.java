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
public class Demo {
     public static void main(String[] args)
              {

////static Nested class的创建，可以直接实例化:
//      OuterClass.StaticNestedClass myNestClass=new OuterClass.StaticNestedClass();
////InnerClass的创建，不可以直接实例化，需要通过外部类的对象创建：
//      OuterClass myOuterClass=new OuterClass();
//      OuterClass.NestClass myInnerClass=myOuterClass.new NestClass();
//      //OuterClass.NestClass myInnerClass=new OuterClass.NestClass();
////shadow:
// OuterClass st = new OuterClass();
//        OuterClass.FirstLevel fl = st.new FirstLevel();
//        fl.methodInFirstLevel(23);
//        Backward jinshuai=new Backward("jinshuai");
//        jinshuai.toString("jinshuai");
//        System.out.println(jinshuai.myString);
    
   /*  Cat myCat = new Cat();
     Animal myAnimal = myCat;
     Animal.testClassMethod();    
      myAnimal.testClassMethod();  
       Cat.testClassMethod();  
        myAnimal.testInstanceMethod();   
        myCat.testInstanceMethod();
        Animal myAnimal2 = new Animal();
        myAnimal2.testInstanceMethod();*/
              }
     
}
