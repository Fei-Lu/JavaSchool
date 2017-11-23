/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

/**
 *
 * @author Aoyue
 */
public class LambdaCalculator {
   
    interface IntegerMath {
        int operation(int a, int b);   
    }
   
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
}