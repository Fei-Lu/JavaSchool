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
class Trees { 
    void photosynthesis(){
    System.out.println("I'm doing photosynthesis");
}
    void respiration(){
    System.out.println("I'm doing respiration");
}
    void transpiration(){
    System.out.println("I'm doing transpiration");
}
class AppleTrees extends Trees { 
    void photosynthesis(){
    System.out.println("AppleTrees are doing photosynthesis");
    } 
    void respiration(){
    System.out.println("AppleTrees are doing respiration");
    }
    void transpiration(){
    System.out.println("AppleTrees are doing transpiration");
    }
    void photosynthesisTest() {
    this.photosynthesis(); 
    super.photosynthesis();
    }
    void respirationTest() {
    this.respiration(); 
    super.respiration();
    }
    void transpirationTest() {
    this.transpiration(); 
    super.transpiration();
  }
}
}
public class Test {
  public static void main(String[] args) {
    Trees a = new Trees();
    Trees b = new Trees();
    Trees c = new Trees();
    a.photosynthesis();
    b.respiration();
    c.transpiration();
    AppleTrees d = new AppleTrees();
    AppleTrees e = new AppleTrees();
    AppleTrees f = new AppleTrees();
    d.photosynthesisTest();
    e.respirationTest();
    f.transpirationTest();
  }

    

