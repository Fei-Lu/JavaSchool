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
public class Breeding {
    public void Breeding(){
    }
   public static void main (String[] args) {

//Class and extends:
    Yao.Tree a=new Yao.Tree(1973);
    Yao.PineApple c=new Yao.PineApple(12,12,12,"yellow","abc");
/*    Maple highMaple=new Maple();
    System.out.println(highMaple.height);
    highMaple.SufferedDisease();
    System.out.println(highMaple.height);
    highMaple.watering();/* Methods from Interface
    System.out.println(highMaple.height);
    Plant Plants=new Plant();
    Plants.ShowPlant();*/
    Tree highTree=new Tree();
    highTree.Showheight();
    Maple bigMaple=new Maple("yellow");
       System.out.println(bigMaple.leafcolor);
    bigMaple.setcolor("blue");
    System.out.println(bigMaple.leafcolor);

//this:
    highTree.NumOfLeaf=150;
    System.out.println(highTree.NumOfLeaf);/*可直接更改*/
    highTree.SetLeafNum(150);
    
    System.out.println(highTree.NumOfLeaf);/*无THIS时，不能更改*/
//new Card
        Card mycard=new Card(1, 1);
//new object 
        Wheat kn199=new Wheat(3,2,3);
        System.out.println(kn199.wateringWheat(3));
        System.out.println(kn199.wateringWheat(3,3));
        System.out.println(kn199.wateringWheat(3,3,3));
//private
//System.out.println(kn199.yield); 
//传值与传址-int-不变-传值
          int  yield=3;
         yieldbreeding(yield);
         System.out.println(yield);
//传值与传址-double-不变-传值
          double water=3;
          pool(water);
          System.out.println(water);
//传值与传址-String-不变-传址
          String BreedName="BobWhite";
          AgriMinistry(BreedName);
          System.out.println(BreedName);
//传值与传址-StringBuffer-变-传址
          StringBuffer BreedName2=new StringBuffer("BobWhite");
          NewAgriMinistry(BreedName2);
          System.out.println(BreedName2);
//传值与传址-list-变-传址
/*          int[] a=new int[3];
          a[1]=1;
          a[2]=1;
          //a[3]=1;
          int[] b={1,2,3};
          ab(a);
          b=a;
          System.out.println(a[2]);
          System.out.println(b[2]);
          */
       }
      ;
    String wheatyield="high yield";
    public static int yieldbreeding(int yield) {
        
        System.out.println("GotHighYieldBreed");
        yield=yield+1;
         return yield;
    }
    public static double pool(double water) {
        water=water+1;
        return water;
    }
     public static String AgriMinistry(String BreedName) {
       
       String Newname=BreedName;
       Newname="ChinaWheat";
       return Newname;
       
     }
    public static StringBuffer NewAgriMinistry(StringBuffer BreedName2) {
       
       StringBuffer Newname=BreedName2;
       BreedName2.append("China");
       return BreedName2;
    }
    Wheat kn199= new Wheat(3,3,3);
    public static int [] ab(int[] a) {
       a[2]=99;
       return a;
       
    }
  
     
    
    
    
  
}
