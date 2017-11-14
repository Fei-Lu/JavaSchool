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
public class Tree {
    int years;
    double diameter;
    double height;
    String leafColor = "green"; 
    String variety;
    
    // mulitple constructors
    public Tree(){
        this(0,0.1,1.2,"green","Orange");
    }
    public Tree(int years){
        this(years,0.1,1.2,"green","Orange");
    }
    public Tree(double diameter,double height){
        this(0,diameter,height,"green","Orange");
    }
    public Tree(String variety){
        this(0,0.1,1.2,"green",variety);
    }
    public Tree(int years, double diameter, double height,String leafColor,String variety){
        this.years = years;
        this.diameter = diameter;
        this.height = height;
        this.leafColor = leafColor;
        this.variety = variety;
    }
    void growingState(String leafColor){
        System.out.print("Growing state: ");
        if ("yellow".equals(leafColor)){
            System.out.println("Waring！Bad condition, need nutrition!");
        }
        if ("green".equals(leafColor)){
            System.out.println("Well condition!");
        }
    }
    double getHeight(){
       height = height + years*10;
       return height;
   }
    double getDiameter(){
       diameter = diameter + years*0.5;
       return diameter;
   }
    void getInfo(){
        System.out.println("Attributes of this tree: " );
        System.out.println("Variety is: " + variety);
        diameter = getDiameter();
        System.out.println("Diameter is: " + diameter );
        height = getHeight();
        System.out.println("Height is: " + height );
        growingState(leafColor);
    }
}

