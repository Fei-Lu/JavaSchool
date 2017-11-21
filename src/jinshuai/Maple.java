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
    public String leafcolor="green";
    /*interface Methods*/
    @Override
    public double watering() {
         height=height+1;
        return height;
    }
    public Maple(String leafcolor){
        this.leafcolor=leafcolor;
    }
    public Double SufferedDisease(){
        height=height-1;
        return height;
        
    }
    public void setcolor(String newcolor){
       leafcolor=newcolor;
       
    }
    public static double SetLeafNum(double NumOfLeaf){
 //       this.NumOfLeaf=NumOfLeaf;
        return NumOfLeaf;
    }
}
