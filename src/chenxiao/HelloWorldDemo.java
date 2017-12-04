/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;
import Yao.Tree;
import Yao.PineApple;
/**
 *
 * @author cauxu
 */
class Person {
    private int age;
    private String name;
    public Person(int a){
        this.age=a;
    }
    Person(int b,String nm){
        this(b);
        this.name=nm;
    }
    public boolean equalsTo(int a){
        boolean SameAge=this.age==a;
        System.out.println(SameAge);
        return SameAge;
    }
}
public class HelloWorldDemo {
    public static void main(String[] args){
        Tree a=new Tree(1973,2,45,"green","dfdf");
        PineApple b=new PineApple(2,23,2,"green","dfv");
        Person p1=new Person(22);
        p1.equalsTo(22);
        String s="myname";
        s="xuechenxiao";
        System.out.println(s);
        
        ShadowClass sc=new ShadowClass();
        ShadowClass.staticclass ic=new ShadowClass.staticclass();//static nested class 可通过outerclass直接创建对象，
                                                               //但inner class需通过实现一个outclass的对象来创建其对象
        sc.toOuterClassValue();
        ic.toValue();
        System.out.println(Integer.TYPE);
    }
    public Integer integerTest(String a){
        Integer s=new Integer(a);
        Integer t=4;
        return s;
    }
}
