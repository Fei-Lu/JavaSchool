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
public class HelloWorldApp {
    public static void main(String[] args){
//        Card card1 = new Card(12,1);
//        
//        System.out.println("hello2");
//        
//        Tree tree1 = new Tree("orange");
//        PineApple tree2 = new PineApple(1,1.8,10.4,"yellow","PineApple");
//        tree1.getInfo();
//        tree2.getInfo();
//        PineApple tree3 = new PineApple(20);
//        tree3.getInfo();
//        ShadowTest st = new ShadowTest();
//        ShadowTest.FirstLevel fl = st.new FirstLevel();
//        fl.methodInFirstLevel(23);
//        Tree treetest = new Tree(1973);
          String a = new String("hello!");
          StringBackwards aa = new StringBackwards(a);
          String d = aa.getBackwardSequence();
          System.out.println(aa.getBackwardSequence()) ;
    }
}
