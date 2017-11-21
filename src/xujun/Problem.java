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








class DataStructure {
// Create an array
private final static int SIZE = 15;
private int[] arrayOfInts = new int[SIZE];

public DataStructure() {
// fill the array with ascending integer values
    for (int i = 0; i < SIZE; i++) {
        arrayOfInts[i] = i;
    }
}

public void printEven() {

    // Print out values of even indices of the array
    DataStructureIterator iterator = this.new EvenIterator();
    while (iterator.hasNext()) {
        System.out.print(iterator.next() + " ");
    }
    System.out.println();
}

interface DataStructureIterator extends java.util.Iterator<Integer> { } 

// Inner class implements the DataStructureIterator interface,
// which extends the Iterator<Integer> interface

private class EvenIterator implements DataStructureIterator {

// Start stepping through the array from the beginning
    private int nextIndex = 0;

    public boolean hasNext() {

// Check if the current element is the last in the array
        return (nextIndex <= SIZE - 1);
    } 

    public Integer next() {

// Record a value of an even index of the array
        Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

// Get the next even element
        nextIndex += 2;
        return retValue;
    }
}

   
}