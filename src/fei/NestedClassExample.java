/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

/**
 *
 * @author feilu
 */
public class NestedClassExample {
    public int a = 0;
    public String b = "12345";
    
    public NestedClassExample () {
        this.startTests();
    }
    
    public NestedClassExample (int a, String b) {
        this.a = a;
        this.b = b;
        this.startTests();
    }
    
    
    private void startTests () {
        this.test01();
        this.test02();
        this.test03();
        this.test04();
    }
    
    public void test04 () {
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
    
    /**
     * Shadow
     */
    public void test03 () {
        new InnerClass().shadowTest();
    }
    
    /**
     * Creating an object of inner class
     */
    public void test02 () {
        InnerClass ic1 = new InnerClass();
        //This step causes runtime error, StackOverflowError, because in->out->in
        //InnerClass ic2 = new OuterClass().creatObjectOfInnerClass();
    }
    
    /**
     * Creating an object of static nested class
     */
    private void test01 () {
        StaticNestedClass snc1 = new StaticNestedClass();
        StaticNestedClass snc2 = new OuterClass().creatObjectOfStaticNestedClass();
    }
    
    static class StaticNestedClass {
        int a = 3;
        public StaticNestedClass () {
            
        }
        
    }
    
    class InnerClass {
        int a = 1;
        
        public InnerClass () {
            
        }
        
        public void shadowTest () {
            System.out.println("this.a = " + this.a);
            System.out.println("this.a = " + NestedClassExample.this.a);
        }
    }
    
}

class OuterClass {
    public int a = 0;
    public String b = "12345";
    
    public OuterClass () {
        
    }
    
    public NestedClassExample.StaticNestedClass creatObjectOfStaticNestedClass () {
        return new NestedClassExample.StaticNestedClass();
    }
    
    public NestedClassExample.InnerClass creatObjectOfInnerClass () {
        return new NestedClassExample().new InnerClass();
    }
}

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
        
        @Override
        public boolean hasNext() {
            
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }        
        
        @Override
        public Integer next() {
            
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
    
}

