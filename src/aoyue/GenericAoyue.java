/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Aoyue
 */
public class GenericAoyue {

    public GenericAoyue() {
        this.HeapPollutionExample (); 
        
    }

    public void HeapPollutionExample() {
        List<String> stringListA = new ArrayList<String>();
        List<String> stringListB = new ArrayList<String>();

        ArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
        ArrayBuilder.addToList(stringListB, "Ten", "Eleven", "Twelve");
        List<List<String>> listOfStringLists =
          new ArrayList<List<String>>();
        ArrayBuilder.addToList(listOfStringLists,
          stringListA, stringListB);

        ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
       
    }
        
        
        
        
    }


    class Node<T> {
       private T data;
       private Node<T> next;
       public Node(T data, Node<T> next) {
       this.data = data;
       this.next = next;
    }
    public T getData() { return data; }
    // ...
}
    
    
    class Nodee {
        private Object data;
    private Nodee next;

    public Nodee(Object data, Nodee next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
    }
    

    class Nodae<T extends Comparable<T>> {
        private T data;
    private Nodae<T> next;

    public Nodae(T data, Nodae<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
        
    }
    
    
    class Nodeee {
        private Comparable data;
    private Nodeee next;

    public Nodeee(Comparable data, Nodeee next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
    // ...
        
    }
    

// Counts the number of occurrences of elem in anArray.
//
public static <T> int count(T[] anArray, T elem) {
    int cnt = 0;
    for (T e : anArray)
        if (e.equals(elem))
            ++cnt;
        return cnt;
}


public static int count(Object[] anArray, Object elem) {
    int cnt = 0;
    for (Object e : anArray)
        if (e.equals(elem))
            ++cnt;
        return cnt;
}


public static <T extends Shape> void draw(T shape) { /* ... */ }


public static void draw(Shape shape) { /* ... */ }


class ArrayBuilder {
    public static <T> void addToList (List<T> listArg, T... elements) {
    for (T x : elements) {
      listArg.add(x);
    }
    public static void faultyMethod(List<String>... l) {
      Object[] objectArray = l;     // Valid
      objectArray[0] = Arrays.asList(42);
      String s = l[0].get(0);       // ClassCastException thrown here
  }
}







