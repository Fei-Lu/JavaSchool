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
public class Breeding {
    public static void main (String[] args) {
//new object 
        Wheat kn199=new Wheat(3,2,3);
        System.out.println(kn199.wateringWheat(3));
        System.out.println(kn199.wateringWheat(3,3));
        System.out.println(kn199.wateringWheat(3,3,3));
//private
        //System.out.println(kn199.yield); 

 }
}
