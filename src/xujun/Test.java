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
import java.util.Calendar;
import java.util.Locale;
import java.text.*;

//DecimalFormat is a concrete subclass of NumberFormat that formats decimal numbers. 
public class Test {

   static public void customFormat(String pattern, double value ) {//it offers a great deal of flexibility in the formatting of numbers
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      System.out.println(value + "  " + pattern + "  " + output);
   }

   static public void main(String[] args) {

      customFormat("###,###.###", 123456.789);//通过decimalnumber里面的pattern对十进制数的格式进行修改
      customFormat("###.##", 123456.789);
      customFormat("000000.000", 123.78);
      customFormat("$###,###.###", 12345.67);  
      
      
//TestFormat
      long n = 461012;//field
      System.out.format("%d%n", n);      //  -->  "461012"
      System.out.format("%08d%n", n);    //  -->  "00461012" Eight characters in width, with leading zeroes as necessary.
      System.out.format("%+8d%n", n);    //  -->  " +461012"
      System.out.format("%,8d%n", n);    // -->  " 461,012" Includes locale-specific grouping characters.
      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
      
      double pi = Math.PI;
    //field static double PI  The double value that is closer than any other to pi, the ratio of the circumference（周长） of a circle to its diameter.


      System.out.format("%f%n", pi);       // -->  "3.141593"
      System.out.format("%.3f%n", pi);     // -->  "3.142"
      System.out.format("%10.3f%n", pi);   // -->  "     3.142"10位有效数字 小数点后3位
      System.out.format("%-10.3f%n", pi);  // -->  "3.142"-代表Left-justified（左对齐）
      System.out.format(Locale.FRANCE,
                        "%-10.4f%n%n", pi); // -->  "3,1416"

      Calendar c = Calendar.getInstance();//getInstance() Gets a calendar using the default time zone and locale.
      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

      System.out.format("%tD%n", c);    // -->  "05/29/06"      
      
// BasicMathDemo
      double a = -191.635;
      double b = 43.74;
      int e= 16, d = 45;

        System.out.printf("The absolute value " + "of %.3f is %.3f%n", 
                          a, Math.abs(a));//Returns the absolute value of the argument.

        System.out.printf("The ceiling of " + "%.2f is %.0f%n", 
                          b, Math.ceil(b));//Returns the smallest integer that is greater than or equal to the argument. Returned as a double.

        System.out.printf("The floor of " + "%.2f is %.0f%n", 
                          b, Math.floor(b));//Returns the largest integer that is less than or equal to the argument. Returned as a double.

        System.out.printf("The rint of %.2f " + "is %.0f%n", 
                          b, Math.rint(b));//Returns the integer that is closest in value to the argument. Returned as a double.

        System.out.printf("The max of %d and " + "%d is %d%n",
                          e, d, Math.max(e, d));

        System.out.printf("The min of of %d " + "and %d is %d%n",
                          c, d, Math.min(e, d));
//ExponentialDemo
       
        double x = 11.635;
        double y = 2.76;

        System.out.printf("The value of " + "e is %.4f%n",
                          Math.E);

        System.out.printf("exp(%.3f) " + "is %.3f%n",
                          x, Math.exp(x));

        System.out.printf("log(%.3f) is " + "%.3f%n",
                          x, Math.log(x));

        System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n",
                          x, y, Math.pow(x, y));

        System.out.printf("sqrt(%.3f) is " + "%.3f%n",
                          x, Math.sqrt(x));
   }
}