/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author feilu
 */
public class CollectionExample {
    
    public CollectionExample () {
        this.basicTest();
    }
    
    public void basicTest () {
        List<String> alist = new ArrayList<>();
        String a1 = "1";
        String b1 = "1";
        alist.add(a1);
        if (alist.contains(b1)) { //contains invove equals, this is true because equals is implemented in String by comparing the content (not reference) of the string
            System.out.println("fine");
        }
        alist.clear();
        alist.add("1");
        alist.add("2");
        alist.add("3");
        alist.stream().filter(e -> e.startsWith("1")).forEach(e -> System.out.println(e));
        int sum = alist.stream().mapToInt(e -> Integer.parseInt(e)).sum();
        String concatenation = alist.stream().collect(Collectors.joining(","));
        System.out.println(sum);
        System.out.println(concatenation);
        
    }
    
}
