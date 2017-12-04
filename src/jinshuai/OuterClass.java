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
public class OuterClass {
    int a=1;
    public static int b=2;
   
    public class NestClass{
        public void print(){
            System.out.println(b);
            //NestClass相当于普通的成员方法，可以访问静态和非静态变量
            System.out.println(a);
        }
//内部类innerClass不能定义静态方法         
//        public static void printS(){
//            System.out.println(b);
//            //System.out.println(a);
//        }
    }
    static class StaticNestedClass {
        public void print(){
            System.out.println(b);
            //Static的NestClass相当于静态方法，不能访问非静态变量
            //System.out.println(a);
        }
        public static void printS(){
            System.out.println(b);
            //System.out.println(a);
        }
    }
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("OutClass.this.x = " + OuterClass.this.x);
        }
    }
}
