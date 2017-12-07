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
public class StringDemo {
    public static void test(){
        testCreatingFormatString();
        testConvertingStringtoNumbers();
        testConvertingNumberstoStrings();
        
    }
    public static void testCreatingFormatString(){
        float floatVar = 666;
        int intVar = 666;
        int stringVar = 666;       
        System.out.printf("The value of the float " +
                  "\nvariable is %f, while " +
                  "\nthe value of the " + 
                  "\ninteger variable is %d, " +
                  "\nand the string is %s", 
                  floatVar, intVar, stringVar);
        String fs;
        fs = String.format("The value of the float " +
                   "\nvariable is %f, while " +
                   "\nthe value of the " + 
                   "\ninteger variable is %d, " +
                   "\nand the string is %s",
                   floatVar, intVar, stringVar);
        System.out.println(fs);
    }
    
     public static void testConvertingStringtoNumbers(){
        String[] args = null;
        // this program requires two 
        // arguments on the command line 
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue(); 
            float b = (Float.valueOf(args[1])).floatValue();

            // do some arithmetic
            System.out.println("a + b = " +
                               (a + b));
            System.out.println("a - b = " +
                               (a - b));
            System.out.println("a * b = " +
                               (a * b));
            System.out.println("a / b = " +
                               (a / b));
            System.out.println("a % b = " +
                               (a % b));
        } else {
            System.out.println("This program " +
                "requires two command-line arguments.");
        }
    }
     
     public static void testConvertingNumberstoStrings() {
        double d = 858.48;
        String s = Double.toString(d);
        
        int dot = s.indexOf('.');
        
        System.out.println(dot + " digits " +
            "before decimal point.");
        System.out.println( (s.length() - dot - 1) +
            " digits after decimal point.");
    }
}
