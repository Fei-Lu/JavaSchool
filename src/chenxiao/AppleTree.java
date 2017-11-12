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
public class AppleTree extends Tree implements Fructify{
    public static String type="Angiosperms";
    public void bearFruit(){
        System.out.println(" I can bear apple");
    }
    public void bloom(){
        System.out.println("Flower is pink");
    }
}
