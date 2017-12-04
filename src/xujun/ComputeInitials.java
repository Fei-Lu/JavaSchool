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

    
public class ComputeInitials {
    public static void main(String[] args) {
        String myName = "Fred F. Flintstone";
        StringBuffer myInitials = new StringBuffer();
//A thread-safe, mutable sequence of characters. A string buffer is like a String, but can be modified. 
//At any point in time it contains some particular sequence of characters, but the length and content of the sequence 
//can be changed through certain method calls. 
        int length = myName.length();

        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(myName.charAt(i))) {
                myInitials.append(myName.charAt(i));
//String和StringBuilder是有区别的 其中一个就是StringBuilder比String多两个方法 append和insert
            }
        }
        System.out.println("My initials are: " + myInitials);
    }
}
    

