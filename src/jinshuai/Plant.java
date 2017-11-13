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
public class Plant {
    public double PhotosynthesisSpeed;
    public double height=10;
    public static String Color ="green";
    
    public String SetColor(String Color){
        this.Color=Color;
        return Color;
    }
    public void ShowPlant(){
        System.out.println("Plant class includes Wheat and Tree, and Maple extends to Tree.Their color are"+Color+"They are"+height+"metres high");
        
    }
}
