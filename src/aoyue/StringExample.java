/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

/**
 *注释都在上面写着，千万别看错了。
 * @author Aoyue
 */
public class StringExample {
    public StringExample () {
        this.outputLength ();
        this.outputConcat ();
//        this.outputFormatStrings ();
        this.outputConvert();
    }
    public void outputLength () {
         String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];
        
        // put original string in an 
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = 
            //返回指定索引处的 char 值。
                palindrome.charAt(i);
        } 
        
        // reverse array of chars  返回倒数的字符值
        for (int j = 0; j < len; j++) {
            charArray[j] =
                tempCharArray[len - 1 - j];
        }
        //String类提供一个字符数组参数来初始化字符串
        String reversePalindrome =
            new String(charArray);
        System.out.println(reversePalindrome);
    }
    public void outputConcat () {
        System.out.println("My name is ".concat ("Aoyue"));
        System.out.println("My name is "+ "Aoyue");
        String myName = "My name is "+ 
                "Aoyue.";
        System.out.println(myName);
        
    }
    public void outputConvert () {
        // this program requires two 
        // arguments on the command line 
        if (args.length == 2) {
            String[] args = null;
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
        
        
    
}
