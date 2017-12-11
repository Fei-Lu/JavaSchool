/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xujun;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Jun Xu
 */
public class StringDemo {
    public static void test(){
      characterDemo();
      buildAString();
      reverseString();
      valueOfDemo();
      methodOfString();
      regionMatchesDemo();
      unBoxingDemo();
    }
    
    public static void characterDemo(){
      System.out.println(Character.isLetter('c'));
      System.out.println(Character.isDigit('c'));
      System.out.println(Character.isWhitespace('\n'));//检查是不是空
      System.out.println( Character.isLowerCase('c'));
      System.out.println("She said \"Hello!\" to me.");
      System.out.println("She said \nHello! %n to me.");
   }
    
    public static void buildAString(){
      String greeting = "Hello!";
      System.out.println(greeting);
      
      char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '!' };
      String helloString = new String(helloArray);
      System.out.println(helloString);
      
      String s = new String("Hello!");//字符串池，重新建立对象，会占用另外的内存
      System.out.println(s);
     }
    public static void reverseString(){
        String a = "I was Superwomen";
        int len = a.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];
        
        // put original string in an 
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = 
                a.charAt(i);
        } 
        
        // reverse array of chars
        for (int j = 0; j < len; j++) {//int j=len-1;j>=0;i--
            charArray[j] =
                tempCharArray[len - 1 - j];
        }
        
        String reversePalindrome =
            new String(charArray);
        System.out.println(reversePalindrome);
        
        
        a.getChars(0, len, tempCharArray, 0);
        System.out.println(charArray);
        

        StringBuilder sb = new StringBuilder(a); //可直接调用reverse方法
        sb.reverse();  // reverse it 
        System.out.println(sb);
     }
    public static void valueOfDemo(){
        char[] args = new char[1];
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue(); //float a = Float.parseFloat(args[0]);
            float b = (Float.valueOf(args[1])).floatValue();//float b = Float.parseFloat(args[1]);
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
    public static void toStringDemo() {
        double d = 858.48;
        String s = Double.toString(d);
        
        int dot = s.indexOf('.');
        
        System.out.println(dot+ " digits " +"before decimal point.");
        System.out.println( (s.length() -dot- 1) +" digits after decimal point.");
    }
    public static void methodOfString(){ 
        String anotherPalindrome = "Niagara. O roar again!"; 
        String q = anotherPalindrome.substring(16, 21);
        String w = anotherPalindrome.substring(16);
        System.out.println(q+"  "+w);
        
        System.out.println(anotherPalindrome.indexOf('o'));
        System.out.println(anotherPalindrome.lastIndexOf('a'));
        System.out.println(anotherPalindrome.replace('o', 'T'));//仅能替换字符，不能替换字符串
        System.out.println(anotherPalindrome.replaceAll("a", "o"));
        System.out.println(anotherPalindrome.replaceFirst("a", "o"));
    }

    public static void regionMatchesDemo() {
        String Str1 = new String("www.weiboa.com");
        String Str2 = new String("weiboa");
        String Str3 = new String("WEIBOA");

        System.out.print("返回值 :" );
        System.out.println(Str1.regionMatches(4, Str2, 0, 5));

        System.out.print("返回值 :" );
        System.out.println(Str1.regionMatches(4, Str3, 0, 5));

        System.out.print("返回值 :" );
        System.out.println(Str1.regionMatches(true, 4, Str3, 0, 5));
    }
    public static void unBoxingDemo(){
        Integer i = new Integer(-8);

        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        ArrayList<Double> ld = new ArrayList<Double>();//list 里面只可以放object
        ld.add(3.1416);    // Π is autoboxed through method invocation.
        
        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }

}
    

