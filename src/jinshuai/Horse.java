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
public class Horse {
      public String identifyMyself() {
        return "I am a horse.";
    }
}
 interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}
 interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}
 class Pegasus extends Horse implements Flyer, Mythical {
    public static void main(String... args) {
        Pegasus myApp = new Pegasus();
        System.out.println(myApp.identifyMyself());
    }
}
