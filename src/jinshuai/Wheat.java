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
//extends
public class Wheat extends Plant  {
    private int yield;
    private int grothrate;
    private int waterdemand;
//Constructors
    public Wheat(int startyield, int startgrothrate, int startwaterdemand){
        yield=startyield;
        grothrate=startgrothrate;
        waterdemand=startwaterdemand;
    }
    public int getyield(){
        return yield;
        }
    public void setyield(int newyield){
        yield=newyield;
    }
    //overloading:
    public int wateringWheat(int irrigationamount){
        yield=yield+irrigationamount;
        return yield;
    }
    //varargs:
    public int wateringWheat(int... irrigationamount){
        for (int a = 0; a < irrigationamount.length; a++) {
            yield=yield+irrigationamount[a];
        }
        return yield;
    }
    public int wateringWheat(int irrigationamount1, int irrigationamount2){
        yield=yield+irrigationamount1+irrigationamount2;
        return yield;
    }
    
           
}
