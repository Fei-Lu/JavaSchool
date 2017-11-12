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
public class CarTestDemo {
     public static void main(String[] args){
        Car Car1=new Car();
        System.out.println(Car1.speed);
        System.out.println(Car1.colour);
        int[] c={'b','l','u','e'};
        Car1.changeColour(c);
        Car1.changeSpeed(100);
        System.out.println(Car1.speed);
        System.out.println(Car1.colour);//class 里的成员变量也是引用数据类型，有自己的地址值
    }
}
