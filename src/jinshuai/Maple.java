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
public class Maple extends Tree implements Irrigation{
    public double height=15;
    /*interface Methods*/
    public Double watering() {
         height=height+1;
        return height;
    }
    public Double SufferedDisease(){
        height=height-1;
        return height;
        
    }
    
}
