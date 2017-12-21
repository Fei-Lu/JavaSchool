/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author feilu
 */
public class CollectionExample {
    Person[] personArray = null; 
    List<Person> personList = null;
    public CollectionExample () {
        this.initialize();
        //this.basicTest();
        //this.setTest();
        //this.listTest();
        //this.queueTest();
        this.mapTest();
    }
    
    public void mapTest () {
        
    }
    
    public void dequeTest () {
        //unsupported yet
    }
    
    public void queueTest () {
        //unsupported yet
    }
    
    public void listTest () {
        List<Integer> alist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            alist.add(i);
        }
        System.out.println(alist);
        alist.remove(1);
        System.out.println(alist);
        alist.set(1, 1);
        System.out.println(alist);
        alist.add(2, 2);
        System.out.println(alist);
        Collections.shuffle(alist);
        System.out.println(alist);
        
        alist.clear();
        for (int i = 0; i < 10; i++) {
            alist.add(i);
        }
        ListIterator<Integer> itr = alist.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
            System.out.println(alist);
        }
        
        alist.clear();
        for (int i = 0; i < 10; i++) {
            alist.add(i);
        }
        List<Integer> sublist = alist.subList(1, 5);
        System.out.println(sublist);
        System.out.println(sublist.indexOf(1));
        Collections.reverse(alist);
        System.out.println(alist);
        Collections.reverse(alist);
        System.out.println(alist);
        Collections.rotate(alist, 2);
        System.out.println(alist);
    }
    
    public void setTest () {
        this.basicSetTest();
    }
    
    public void basicSetTest () {
        ArrayList<String> alist = new ArrayList();
        alist.add("a");
        alist.add("a");
        System.out.println(alist);
        //create collections with no duplication
        Set<String> aset = new HashSet(alist);
        System.out.println(aset);
        
        Set<String> bset = alist.stream().collect(Collectors.toSet());
        System.out.println(bset);
        
        Set<String> cset = personList.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(cset);
        
        aset.add("b");
        bset.add("c");
        
        System.out.println(aset.containsAll(bset));
        
        System.out.println("aset:"+aset+"\tbset:"+bset);
        Set<String> dset = aset.stream().collect(Collectors.toSet());
        dset.addAll(bset);
        System.out.println("addAll:"+dset);
        
        dset = aset.stream().collect(Collectors.toSet());
        dset.retainAll(bset);
        System.out.println("retainAll"+dset);
        
        dset = aset.stream().collect(Collectors.toSet());
        dset.removeAll(bset);
        System.out.println("removeAll:"+dset);
        
    }
    
    public void basicTest () {
        List<String> alist = new ArrayList<>();
        String a1 = "1";
        String b1 = "1";
        alist.add(a1);
        if (alist.contains(b1)) { //contains invoke equals, this is true because equals is implemented in String by comparing the content (not reference) of the string
            System.out.println("fine");
        }
        
        //Aggregate operations
        alist.clear();
        alist.add("1");
        alist.add("2");
        alist.add("3");
        alist.stream().filter(e -> e.startsWith("1")).forEach(e -> System.out.println(e));
        int sum = alist.stream().mapToInt(e -> Integer.parseInt(e)).sum();
        String concatenation = alist.stream().collect(Collectors.joining(","));
        System.out.println(sum);
        System.out.println(concatenation);
        
        System.out.println("For each on list");
        for (String s : alist) {
            System.out.println(s);
        }
        
        System.out.println("Iterator and remove");
        Iterator<String> itr = alist.iterator();
        while (itr.hasNext()) {
            String e = itr.next();
            if (e.equals("3")) {
                itr.remove();
            }
        }
        for (String s : alist) {
            System.out.println(s);
        }
        
        System.out.println("For each on set");
        HashSet<String> aset = new HashSet<>();
        aset.add("1");
        aset.add("2");
        aset.add("3");
        for (String s : aset) {
            System.out.println(s);
        }
        
        System.out.println("Remove all");
        aset.removeAll(alist);
        for (String s : aset) {
            System.out.println(s);
        }
    }
    
    public void initialize () {
        int size = 4;
        personArray = new Person[size];
        Person p1 = new Person("John Snow", 24, Person.Sex.MALE, "johnsnow@stark.org");
        Person p2 = new Person ("Daenerys Targaryen", 31, Person.Sex.FEMALE, "dt312@targaryen.org");
        Person p3 = new Person("Cersei Lannister", 46, Person.Sex.FEMALE, "cl@lannister.org");
        Person p4 = new Person("Jaime Lannister", 44, Person.Sex.MALE, "jl@lannister.org");
        personArray[0] = p1;
        personArray[1] = p2;
        personArray[2] = p3;
        personArray[3] = p4;
        personList = new ArrayList<>();
        for (int i = 0; i < personArray.length; i++) {
            personList.add(personArray[i]);
        }
    }
    
}


