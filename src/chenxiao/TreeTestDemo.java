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
public class TreeTestDemo {
    public static void main(String[] args){
        PineTree Pt=new PineTree(34);
        AppleTree At=new AppleTree(23,"green");
        System.out.println(PineTree.type);
        Pt.photosynthesis(24,40);
    }
}
