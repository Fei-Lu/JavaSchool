/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cauxu
 * @param <T>
 */
public class Box<T>{
    private T t;
    private int x;
    public void setT(T t){
        this.t=t; 
    }
    public T getT(){
        return this.t;
    }
    public int getX(int x){
        return this.x=x;
    }
    
    //bounded type parameters
    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
        
        System.out.println(u.intValue()% 2 == 0);
    }
    
    public <T>List  add(T t1,T t2){
        List<T> LI=new ArrayList<>();
        LI.add(t1);
        LI.add(t2);        
        return LI;
    }
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
    
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    @Override
    public K getKey()	{ return key;}
    @Override
    public V getValue() { return value;}
    
    //generic method
    public static <X,Y> boolean compare(Pair p1, Pair p2) {//generic method 表达式
        return p1.getKey().equals(p2.getKey()) &&p1.getValue().equals(p2.getValue());
    }
 
}

class NaturalNumber {

    private final int i;

    public NaturalNumber(int i) { this.i = i; }
    // ...
}
class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    // ...
}

