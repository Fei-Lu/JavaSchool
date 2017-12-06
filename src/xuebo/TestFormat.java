/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Xuebo Zhao
 */
public class TestFormat {
    public static void test(){
        outputValue();
        outputCompare();
        outputEquals();
        outputValueOf();
        outputParseInt();
        outputToString();
        outputFormat();
        outputMathFormat();
        outputCalendar();
        outputDecimalFormat(); 
        outputBasicMath();
        outputExponential();
        outputTrigonometric();
        outputToString2();
    }
    
    public static void outputValue(){
      Integer x = 50000;
      System.out.println( x.byteValue() );
      System.out.println(x.doubleValue());
      System.out.println( x.longValue() ); 
      System.out.println( x.shortValue() );
      System.out.println( x.floatValue() );
   }
    
    public static void outputCompare(){
      Integer x = 5000;
      System.out.println(x.compareTo(3000));
      System.out.println(x.compareTo(5000));
      System.out.println(x.compareTo(8000));            
     }
    
    public static void outputEquals(){
        Integer x = 5000;
        Integer y = 1000;
        Integer z =5000;
        Short a = 5000;
        System.out.println(x.equals(y));  
        System.out.println(x.equals(z)); 
        System.out.println(x.equals(a));
    }
    
    public static void outputValueOf(){
        Integer x =Integer.valueOf(9);
        Double c = Double.valueOf(5);
        Float a = Float.valueOf("80");               
        Integer b = Integer.valueOf("666",16);  
        System.out.println(x); 
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void outputParseInt(){
        int x =Integer.parseInt("5");
        double c = Double.parseDouble("50");
        int b = Integer.parseInt("666",16);
        System.out.println(x);
        System.out.println(c);
        System.out.println(b);
    }
    
    public static void outputToString(){
        Integer x = 5000;
        System.out.println(x.toString());  
        System.out.println(Integer.toString(666)); 
    }
    
    public static void outputFormat(){ 
      long n = 461012;
      System.out.format("%d%n", n);     
      System.out.format("%08d%n", n);    
      System.out.format("%+8d%n", n);    
      System.out.format("%,8d%n", n);    
      System.out.format("%+,8d%n%n", n); 
    }
    
    public static void outputMathFormat(){ 
      double pi = Math.PI;
      System.out.format("%f%n", pi);       
      System.out.format("%.3f%n", pi);     
      System.out.format("%10.3f%n", pi);   
      System.out.format("%-10.3f%n", pi); 
      System.out.format(Locale.FRANCE,
                        "%-10.4f%n%n", pi); 
    }
    
    public static void outputCalendar(){
      Calendar c = Calendar.getInstance();
      System.out.format("%tB %te, %tY%n", c, c, c);
      System.out.format("%tl:%tM %tp%n", c, c, c);  
      System.out.format("%tD%n", c);    
    }
    
    public static void customFormat(String pattern, double value) {
      DecimalFormat myFormatter = new DecimalFormat(pattern);
      String output = myFormatter.format(value);
      System.out.println(value + "  " + pattern + "  " + output);
    }
    public static void outputDecimalFormat (){
      customFormat("###,###.###", 123456.789);
      customFormat("###.##", 123456.789);
      customFormat("000000.000", 123.78);
      customFormat("$###,###.###", 12345.67);      
    }
    
     public static void outputBasicMath(){
        double a = -191.635;
        double b = 43.74;
        int c = 16, d = 45;
        System.out.printf("The absolute value " + "of %.3f is %.3f%n", a, Math.abs(a));
        System.out.printf("The ceiling of " + "%.2f is %.0f%n", b, Math.ceil(b));
        System.out.printf("The floor of " + "%.2f is %.0f%n", b, Math.floor(b));
        System.out.printf("The rint of %.2f " + "is %.0f%n", b, Math.rint(b));
        System.out.printf("The max of %d and " + "%d is %d%n",c, d, Math.max(c, d));
        System.out.printf("The min of of %d " + "and %d is %d%n",c, d, Math.min(c, d));
    }
     
    public static void outputExponential(){
        double x = 11.635;
        double y = 2.76;
        System.out.printf("The value of " + "e is %.4f%n",Math.E);
        System.out.printf("exp(%.3f) " + "is %.3f%n",x, Math.exp(x));
        System.out.printf("log(%.3f) is " + "%.3f%n",x, Math.log(x));
        System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n",x, y, Math.pow(x, y));
        System.out.printf("sqrt(%.3f) is " + "%.3f%n",x, Math.sqrt(x));
    }
    
     public static void outputTrigonometric() {
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);       
        System.out.format("The value of pi " + "is %.4f%n",Math.PI);
        System.out.format("The sine of %.1f " + "degrees is %.4f%n",degrees, Math.sin(radians));
        System.out.format("The cosine of %.1f " + "degrees is %.4f%n",degrees, Math.cos(radians));
        System.out.format("The tangent of %.1f " + "degrees is %.4f%n",degrees, Math.tan(radians));
        System.out.format("The arcsine of %.4f " + "is %.4f degrees %n", Math.sin(radians), Math.toDegrees(Math.asin(Math.sin(radians))));
        System.out.format("The arccosine of %.4f " + "is %.4f degrees %n", Math.cos(radians),  Math.toDegrees(Math.acos(Math.cos(radians))));
        System.out.format("The arctangent of %.4f " + "is %.4f degrees %n", Math.tan(radians), Math.toDegrees(Math.atan(Math.tan(radians))));
    }

    public static void outputToString2(){
       Number sub = new Number("Tina", 2);
       System.out.println(sub);
       sub.change("Bob", 3);
       System.out.println(sub);
    }
}    
    
    
class NameDome {
    private String name;
    protected void set(String a) {
       name = a;
    }
    public NameDome(String name) {
       this.name = name;
    }
//    public String toString() {
//       return "I'm a rabbit and my name is " + name;
//    }
}
class Number extends NameDome {
        private int subNumber;
        public Number(String name, int orcNumber) {
           super(name);
           this.subNumber = orcNumber;
        }
        public void change(String name, int orcNumber) {
           this.subNumber = orcNumber;
        }
        public String toString() {
           return "Age" + subNumber + ":" + super.toString();
        }
}


