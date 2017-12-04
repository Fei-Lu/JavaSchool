/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;

/**
 *
 * @author (name=Xue; Date=2017/12/3)
 */
public class AnonymousClass {
    public  String name;
    public int age;
    public AnonymousClass(String name,int age){
        this.name=name;
        this.age=age;
    }
    public AnonymousClass(String name){
        this(name,22);
    }
    public AnonymousClass(int age){
        this("xue",age);
    }
    interface Greet{
            public void sayHello(); 
            public void introduce1();
        }
    public void introduce(){
        final String name="li";
        final int age=12;
        
        //Greet gt=new Greet();
        Greet IntroduceMyself=new Greet(){
             @Override
             public void sayHello(){
                    System.out.println("Hello");
                }
 //匿名类中不能定义static变量及方法
             @Override
            public void introduce1(){
               System.out.println("My name is "+name);//从内部类应用的变量必须有final 修饰或实际上定义的时final值
               System.out.println("I am  "+age+" years old");
            }
        };
            
        IntroduceMyself.sayHello();//可调用enclose class里的fields and methods
        IntroduceMyself.introduce1();
    }
}
