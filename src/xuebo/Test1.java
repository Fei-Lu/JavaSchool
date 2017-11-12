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
class Treess {
    void photosynthesis(){
        System.out.println("Trees are doing photosynthesis");
}
    void respiration(){
        System.out.println("Trees are doing respiration");
}
    void transpiration(){
        System.out.println("Trees are doing transpiration");
}
}
class AppleTree extends Treess { 
    void photosynthesis(){
        System.out.println("AppleTree is doing photosynthesis");
    } 
    void photosynthesisTest1() {
        this.photosynthesis(); 
        super.photosynthesis();
    }
}
public class Test1 {
    public Test1(String name){
        System.out.println("Tree's name: "+ name);
    }
    public static void main(String[] args) {
        Test1 myTest1 = new Test1("AppleTree");
        Treess a = new Treess();
        Treess b = new Treess();
        Treess c = new Treess();
        a.photosynthesis();
        b.respiration();
        c.transpiration();
        AppleTree d = new AppleTree();
        d.photosynthesisTest1();
  }
}
