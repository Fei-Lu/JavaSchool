/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

/**
 *
 * @author feilu
 */
public class AnnotationExampleSub extends AnnotationExample {
    
    public AnnotationExampleSub () {
        
        String a;
    }
    
    @Override
    public void addValue (int a) {
        value = value+a;
    }
}
