/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yao;

/**
 *
 * @author yaozhou
 */
public class PineApple extends Tree{
//    int years;
//    double diameter;
//    double height;
//    String leafColor = "green"; 
//    String variety;
    
    public PineApple(int years, double diameter, double height, String leafColor, String variety){
        super(years,diameter,height,leafColor,variety);
    }

    public PineApple(){
        this(0,0.1,1.2,"green","Orange");
    }
    public PineApple(int years){
        this(years,0.1,1.2,"green","Orange");
    }
    public PineApple(double diameter,double height){
        this(0,diameter,height,"green","Orange");
    }
    public PineApple(String variety){
        this(0,0.1,1.2,"green",variety);
    }
//    public PineApple(int years, double diameter, double height,String leafColor,String variety){
//        this.years = years;
//        this.diameter = diameter;
//        this.height = height;
//        this.leafColor = leafColor;
//        this.variety = variety;
//    }
    
}
