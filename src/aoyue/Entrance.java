/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import static aoyue.DecimalFormatDemo.customFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Aoyue
 */
public class Entrance {
    
    public Entrance () {
//        this.numbers();  
//        this.string();
//        this.generic();
//        this.listOfNumbers();
        this.collection();
    }
    public void numbers () {
        new NumbersExample();
    }
    public void string() {
        new StringExample();
        
    }
      
    public void generic() {
        new GenericAoyue ();
    }
    public void listOfNumbers() {
        new ListOfNumbers ();
    }
      public void collection() {
        new Collection ();
    }
    public static void main (String[] args) {
        new Entrance ();


       
//        /*************************class TestFormat************************************/
//        long n = 461012;
//      System.out.format("%d%n", n);      //  -->  "461012"
//      System.out.format("%08d%n", n);    //  -->  "00461012"
//      System.out.format("%+8d%n", n);    //  -->  " +461012"
//      System.out.format("%,8d%n", n);    // -->  " 461,012"
//      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
//      
//      double pi = Math.PI;
//
//      System.out.format("%f%n", pi);       // -->  "3.141593"
//      System.out.format("%.3f%n", pi);     // -->  "3.142"
//      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
//      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
//      System.out.format(Locale.FRANCE,
//                        "%-10.4f%n%n", pi); // -->  "3,1416"
//
//      Calendar c = Calendar.getInstance();
//      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
//
//      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
//
//      System.out.format("%tD%n", c);    // -->  "05/29/06"
//      
//      
//      /*****************************class DecimalFormatDemo************************************/
//      customFormat("###,###.###", 123456.789);
//      customFormat("###.##", 123456.789);
//      customFormat("000000.000", 123.78);
//      customFormat("$###,###.###", 12345.67);  
//      
//      
//      /***************************class BasicMathDemo*************************************/
//      double a = -191.635;
//        double b = 43.74;
//        int x = 16, d = 45;
//
//        System.out.printf("The absolute value " + "of %.3f is %.3f%n", 
//                          a, Math.abs(a));
//
//        System.out.printf("The ceiling of " + "%.2f is %.0f%n", 
//                          b, Math.ceil(b));
//
//        System.out.printf("The floor of " + "%.2f is %.0f%n", 
//                          b, Math.floor(b));
//
//        System.out.printf("The rint of %.2f " + "is %.0f%n", 
//                          b, Math.rint(b));
//
//        System.out.printf("The max of %d and " + "%d is %d%n",
//                          x, d, Math.max(x, d));
//
//        System.out.printf("The min of of %d " + "and %d is %d%n",
//                          x, d, Math.min(x, d));
//        
//        /**************class ExponentialDemo***************/
//        double z = 11.635;
//        double y = 2.76;
//
//        System.out.printf("The value of " + "e is %.4f%n",
//                          Math.E);
//
//        System.out.printf("exp(%.3f) " + "is %.3f%n",
//                          z, Math.exp(z));
//
//        System.out.printf("log(%.3f) is " + "%.3f%n",
//                          z, Math.log(z));
//
//        System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n",
//                          z, y, Math.pow(z, y));
//
//        System.out.printf("sqrt(%.3f) is " + "%.3f%n",
//                          z, Math.sqrt(z));
//        
//        
//        /*************************class TrigonometricDemo*************************/
//        double degrees = 45.0;
//        double radians = Math.toRadians(degrees);
//        
//        System.out.format("The value of pi " + "is %.4f%n",
//                           Math.PI);
//
//        System.out.format("The sine of %.1f " + "degrees is %.4f%n",
//                          degrees, Math.sin(radians));
//
//        System.out.format("The cosine of %.1f " + "degrees is %.4f%n",
//                          degrees, Math.cos(radians));
//
//        System.out.format("The tangent of %.1f " + "degrees is %.4f%n",
//                          degrees, Math.tan(radians));
//
//        System.out.format("The arcsine of %.4f " + "is %.4f degrees %n", 
//                          Math.sin(radians), 
//                          Math.toDegrees(Math.asin(Math.sin(radians))));
//
//        System.out.format("The arccosine of %.4f " + "is %.4f degrees %n", 
//                          Math.cos(radians),  
//                          Math.toDegrees(Math.acos(Math.cos(radians))));
//
//        System.out.format("The arctangent of %.4f " + "is %.4f degrees %n", 
//                          Math.tan(radians), 
//                          Math.toDegrees(Math.atan(Math.tan(radians))));
//        
        
       
      
              
//        LambdaScopeTest st = new LambdaScopeTest();
//        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
//        fl.methodInFirstLevel(23);
//////        
//        LambdaCalculator myApp = new LambdaCalculator();
//        LambdaCalculator.IntegerMath addition = (a, b) -> a + b;
//        LambdaCalculator.IntegerMath subtraction = (a, b) -> a - b;
//        System.out.println("40 + 2 = " +
//            myApp.operateBinary(40, 2, addition));
//        System.out.println("20 - 10 = " +
//            myApp.operateBinary(20, 10, subtraction));
        
    }
}
