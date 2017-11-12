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
    System.out.println("I'm doing photosynthesis");
}
    void respiration(){
    System.out.println("I'm doing respiration");
}
    void transpiration(){
    System.out.println("I'm doing transpiration");
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
  public static void main(String[] args) {
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
