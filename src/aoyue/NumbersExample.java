/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import java.text.DecimalFormat;

/**
 *
 * @author Aoyue
 */
public class NumbersExample {
    public NumbersExample () {
    
        
    }
}
class TestFormat {
    
    
}

class DecimalFormatDemo {

   static public void customFormat(String pattern, double value ) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      System.out.println(value + "  " + pattern + "  " + output);
   }

   
}

class BasicMathDemo {
    
}

class ExponentialDemo {
    
}

class TrigonometricDemo {
    
}