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
public class SubClassDemo extends SuperClassDemo {  
//    public static int i = 2;
    public int i = 2;
    public static int j = 1;    
//    public final int k = 4;
    public int k = 4;
    public static void method1() {  
       System.out.println("SubClass Method1");  
    }  
    public void method2() {   
       System.out.println("SubClass Method2");   
    }   
    public static void main(String[] args) {  
       SuperClassDemo sc = new SubClassDemo();  
       System.out.println("i = " + sc.i);  
       System.out.println("j = " + sc.j);  
       System.out.println("k = " + sc.k);  
       sc.method1();//静态方法只能被隐藏  
       sc.method2();  
       SubClassDemo subc = new SubClassDemo();   
       System.out.println("i = " + subc.i);  
       System.out.println("j = " + subc.j);  
       System.out.println("k = " + subc.k);  
       subc.method1();  
       subc.method2();  
    }  
}  
