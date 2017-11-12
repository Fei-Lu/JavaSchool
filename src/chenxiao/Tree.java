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
public class Tree {
    private int height;
    public void photosynthesis(int CO2,int H2O){
        int O2=H2O/2;
        int Carbohydrate=CO2;
        System.out.println(O2);
    }
    public void setHeight(int height){
        this.height=height;
    }
    public int getHeight(){
        return this.height;
    }
}