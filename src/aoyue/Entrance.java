/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import fei.*;

/**
 *
 * @author feilu
 */
public class Entrance {
    
    public static void main (String[] args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
//        
        LambdaCalculator myApp = new LambdaCalculator();
        LambdaCalculator.IntegerMath addition = (a, b) -> a + b;
        LambdaCalculator.IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));
        
    }

}
