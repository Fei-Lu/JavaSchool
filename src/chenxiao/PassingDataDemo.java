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
public class PassingDataDemo {
    public static void main(String[] args){
        String FirstName=new String("Xue");
        changeName(FirstName);
        System.out.println(FirstName);
        System.out.println( );
        
        int[] number=new int[4];
        number[2]=3;
        int i=3;
        changeNumber(number);
        System.out.println(number[2]);
        System.out.println( );
        changeNumber(i);
        System.out.println(i);
        System.out.println( );
        changeNumberAgain(number);
    }
    public static void changeName(String Name){
        String FirstName=Name+"chenxiao";
        System.out.println(FirstName);
    }
    public static void changeNumber(int[] a){
        a[2]++;
        System.out.println(a[2]);
    }
    public static void changeNumber(int a){
        a++;
        System.out.println(a);
    }
    public static void changeNumberAgain(int[] a){
        int[] b=new int[4];
        b=a;
        int x=a[2];
        int y=a[2];
        a[2]++;
        System.out.println("a[2]++ ="+a[2]);
        System.out.println(a);
        System.out.println(b);
        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.println(b[2]);
    }
}
