/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;

import java.util.List;

/**
 *
 * @author 靳帅
 * @param <T>
 */

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}
/*编译器眼中（编译后）的Node
 public class Node {

   private Object data;
   private Node next;

   public Node(Object data, Node next) {
       this.data = data;
       this.next = next;
   }

   public Object getData() { return data; }
   // ...
}*/
class Node2<T extends Comparable<T>> {  
  
   private T data;  
   private Node<T> next;  
  
   public Node2(T data, Node<T> next) {  
       this.data = data;  
       this.next = next;  
   }  
   public T getData() { return data; }  
   // ...  
   
//编译后的有限定的泛型
//public class Node {  
//  
//    private Comparable data;  
//    private Node next;  
//  
//    public Node(Comparable data, Node next) {  
//        this.data = data;  
//        this.next = next;  
//    }  
//  
//    public Comparable getData() { return data; }  
//    // ...  
//}  
// Counts the number of occurrences of elem in anArray.
//
   

   
   
   
//Erasure of Generic Methods
    public static <T> int count(T[] anArray, T elem) {
    int cnt = 0;
    for (T e : anArray)
        if (e.equals(elem))
            ++cnt;
        return cnt;
    }
}
/*泛型擦除后的count方法
public static int count(Object[] anArray, Object elem) {
    int cnt = 0;
    for (Object e : anArray)
        if (e.equals(elem))
            ++cnt;
        return cnt;
}*/



//class Pair2<T>{ 
//    void first();
//      public boolean a(T value){  
//            return (first.equals(value));  
//      }  
//}