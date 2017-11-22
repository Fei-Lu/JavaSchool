/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

/**
 *
 * @author Xuebo Zhao
 */
public class InterFaceTree extends Tree{
    public InterFaceTree(int years, double diameter, double height, String leafColor, String variety){
        super(years,diameter,height,leafColor,variety);
    }

    public InterFaceTree(){
        this(0,0.1,1.2,"green","Orange");
    }
    public InterFaceTree(int years){
        this(years,0.1,1.2,"green","Orange");
    }
    public InterFaceTree(double diameter,double height){
        this(0,diameter,height,"green","Orange");
    }
    public InterFaceTree(String variety){
        this(0,0.1,1.2,"green",variety);
    }
}
