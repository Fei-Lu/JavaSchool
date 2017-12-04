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
public class MaxVariablesDemo {
    public static void main(String args[]) {

        //integers
        byte largestByte = Byte.MAX_VALUE;
        short largestShort = Short.MAX_VALUE;
        int largestInteger = Integer.MAX_VALUE;
        long largestLong = Long.MAX_VALUE;

        //real numbers
        float largestFloat = Float.MAX_VALUE;
        double largestDouble = Double.MAX_VALUE;

        //other primitive types
        char aChar = 'S';
        boolean aBoolean = true;

        //Display them all.
        System.out.println("The largest byte value is "
                           + largestByte + ".");
        System.out.println("The largest short value is "
                           + largestShort + ".");
        System.out.println("The largest integer value is "
                           + largestInteger + ".");
        System.out.println("The largest long value is "
                           + largestLong + ".");

        System.out.println("The largest float value is "
                           + largestFloat + ".");
        System.out.println("The largest double value is "
                           + largestDouble + ".");

        if (Character.isUpperCase(aChar)) {
            System.out.println("The character " + aChar
                               + " is uppercase.");
        } else {
            System.out.println("The character " + aChar
                               + " is lowercase.");
        }
        System.out.println("The value of aBoolean is "
                           + aBoolean + ".");
        //integers
        byte smallestByte = Byte.MIN_VALUE;
        short smallestShort = Short.MIN_VALUE;
        int smallestInteger = Integer.MIN_VALUE;
        long smallestLong = Long.MIN_VALUE;

        //real numbers
        float smallestFloat = Float.MIN_VALUE;
        double smallestDouble = Double.MIN_VALUE;

        //Display them all.
        System.out.println("The smallest byte value is "
                           + smallestByte + ".");
        System.out.println("The smallest short value is "
                           + smallestShort + ".");
        System.out.println("The smallest integer value is "
                           + smallestInteger + ".");
        System.out.println("The smallest long value is "
                           + smallestLong + ".");

        System.out.println("The smallest float value is "
                           + smallestFloat + ".");
        System.out.println("The smallest double value is "
                           + smallestDouble + ".");

    }
}