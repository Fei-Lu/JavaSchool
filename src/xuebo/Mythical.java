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
public interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}
