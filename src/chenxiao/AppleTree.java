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
public class AppleTree extends Tree implements Fructify{
    //public int height;
    public String color;
    public AppleTree(int startHeight,String startColor){
        super(startHeight);//子类不能继承父类的构造方法，仅可调用，子类构造方法必须先调用父类的构造方法
        color=startColor;
    }
    public static String type="Angiosperms";
    public void bearFruit(){
        System.out.println(" I can bear apple");
    }
    public void bloom(){
        System.out.println("Flower is pink");
    }
}
