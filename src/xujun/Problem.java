/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xujun;

/**
 *
 * @author Jun Xu
 */

public class Problem { 
    String s;
    static class Inner {
        void testMethod(String s) {
            s = "Set from Inner";
        }
    }
    
}
class Problem1 { 
    public String a;
    static class Inner1 {
        String a;
        void testMethod() {
            a = "Set from Inner";
        }
    }
    
}





/*class Class1 {
    protected InnerClass1 ic;

    public Class1() {
    ic = new InnerClass1();
    }

    public void displayStrings() {
        System.out.println(ic.getString() + ".");
        System.out.println(ic.getAnotherString() + ".");
    }
    static public void main(String[] args) {
        Class1 c1 = new Class1();
        c1.displayStrings();
    }

    protected class InnerClass1 {
        public String getString() {
            return "InnerClass1: getString invoked";
        }

    public String getAnotherString() {
        return "InnerClass1: getAnotherString invoked";
    }
    }
}
*/








