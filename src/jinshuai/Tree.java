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
public class Tree extends Plant {
    
    public int NumOfLeaf=100;
    public void Showheight(){
        System.out.println("Tree's height is"+height);
    }
    public static int SetLeafNum(int NumOfLeaf){
 //       this.NumOfLeaf=NumOfLeaf;
        return NumOfLeaf;
    }
}
