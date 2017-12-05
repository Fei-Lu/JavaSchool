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
public class AnnotationExample implements AnnotationInferface {
    int value = 1;
    public AnnotationExample () {
        
    }
    
    /**
     * Return the value
     * @return the current value
     */
    public int getValue () {
        return value;
    }
    
    /**
     * Add value to the original value
     * @param a the addition
     */
    public void addValue (int a) {
        value += a;
    }

    @Override
    public void setValue(int a) {
        value = a;
    }
    
    @Override
    public void setValueOld(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Deprecated
    public void setValueOld2 (int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @deprecated 
     * @param a 
     */
    public void setValueOld3 (int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
   
/**
 *
 * @author feilu
 */
interface AnnotationInferface {
    /**
     * Set the value as the input
     * @param a the value to be set
     */
    public void setValue (int a);
    
    /**
     * Set the value as the input
     * @deprecated 
     * @param a the value to be set
     */
    @Deprecated
    public void setValueOld (int a);

}
