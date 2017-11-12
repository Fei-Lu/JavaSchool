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
public class LoopControlDemo {
    public static void main(String[] args){
        int a=5;
        ForDemo(a);
        
        System.out.println( );
        DoWhileDemo(a);
    }
    public static void WhileDemo(int a){
        for(int i=1;i<=a;i++){
            int j=1;
            while(j<=i){
                System.out.print("*");
                j++;
            }
            System.out.println( );
        }
    }
    public static void DoWhileDemo(int a){
        for(int i=1;i<=a;i++){
            int j=1;
            do{
                System.out.print("*");
                j++;
            }while(j<=i);
            System.out.println( );
        }
    }
    public static void ForDemo(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println( );
        }
    }
}
        
