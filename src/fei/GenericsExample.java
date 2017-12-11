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
public class GenericsExample {
    
    public GenericsExample () {
        this.basicTest();
        this.rawTypeTest();
        this.genericMethodTest();
        this.boundedTypeTest();
        this.typeInferenceTest();
        
    }
    
    public void typeInferenceTest () {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =new java.util.ArrayList<>();
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
        
        //Map<String, List<String>> myMap = new HashMap(); //warning
    }
    
    public void boundedTypeTest () {
        Boxx<Integer> integerBox = new Boxx<Integer>();
        integerBox.set(new Integer(10));
        //integerBox.inspect("some text"); // error: this is still String!
        integerBox.inspect(10);
    }
    
    public void genericMethodTest () {
        Pairr<Integer, String> p1 = new Pairr<>(1, "apple");
        Pairr<Integer, String> p2 = new Pairr<>(2, "pear");
        boolean same = Util.<Integer, String>compare(p1, p2);
        
        Pairr<Integer, String> p3 = new Pairr<>(1, "apple");
        Pairr<Integer, String> p4 = new Pairr<>(2, "pear");
        boolean same2 = Util.compare(p3, p4);
    }
    
    public void rawTypeTest() {
        Box<String> stringBox = new Box<>("3");
        Box rawBox = stringBox; 
        
        Box rawBox1 = new Box();           // rawBox1 is a raw type of Box<T>
        Box<Integer> intBox = rawBox1;
        
        Object o = new Object();
        
        //Box<String> abox = o;
        //Box bbox = o;
        
        Box<String> stringBox2 = new Box<>();
        Box rawBox2 = stringBox2;
        rawBox2.set(8);
        //stringBox2.set(8); //warning
    }
    
    public void basicTest () {
        Box<Integer> abox = new Box<Integer>();
        Box<Integer> bbox = new Box();
        
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
        
        Pair<String, Integer> p3 = new OrderedPair("Even", 8);
        Pair<String, String>  p4 = new OrderedPair("hello", "world");
        
        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());
    }
}

class BoxDemo {

    public static <U> void addBox(U u, java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
          U boxContents = box.get();
          System.out.println("Box #" + counter + " contains [" +
                 boxContents.toString() + "]");
          counter++;
        }
    }

}

class Boxx<T> {

    private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

}

class Util {
    public static <K, V> boolean compare(Pairr<K, V> p1, Pairr<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

class Pairr<K, V> {

    private K key;
    private V value;

    public Pairr(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}

class Box<T> {
    // T stands for "Type"
    private T t;
    
    public Box () {
        
    }
    
    public Box (T o) {
        this.t = o;
    }
    
    public void set(T t) { 
        this.t = t; 
    }
    public T get() { return t; }
}

interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}