/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xujun;

/**
 *
 * @author Jun Xu
 */
public class MultipleString extends Thread {
    String name;
    MultipleString(String name){
        this.name=name;
    }
    public void run(){
        for(int x=0;x<10;x++){
            System.out.println(Thread.currentThread().getName());
        }
         
    } 
}
class MultipleStringDemo{
    public static void main(String[] args){
        MultipleString d1=new MultipleString("exercise1");
        MultipleString d2=new MultipleString("exercise2");
        d1.run();
        d2.run();
        for(int x=0;x<20;x++){
            System.out.println(x+Thread.currentThread().getName());
        }
    }
}
