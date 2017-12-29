/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author Planck
 */
public class AggregateOperations {
   public static void main(String[] args){
       
       
     List<Person2> roster = new ArrayList<Person2>();
     Person2 amy=new Person2("Amy",22,Person2.Sex.FEMALE,"Amy@genetics.ac.cn");
     Person2 john=new Person2("John",22,Person2.Sex.MALE,"john@genetics.ac.cn");
     Person2 Mark=new Person2("Mark",25,Person2.Sex.MALE,"Mark@genetics.ac.cn");
     roster.add(amy);
     roster.add(john);
     roster.add(Mark);
//Traverse Method 1:
     for (Person2 p : roster) {
    System.out.println(p.getName());
}
//Traverse Method 2:     
     roster
    .stream()
    .forEach(e -> System.out.println(e.getName()));

//filter
    roster.stream()
    .filter(e -> e.getGender() == Person2.Sex.MALE)
    .forEach(e -> System.out.println(e.getName()));

//filter by For-each loop
for (Person2 p : roster) {
    if (p.getGender() == Person2.Sex.MALE) {
        System.out.println(p.getName());
    }
}

//more complicated Aggregate Operation
   double average = roster
    .stream()
    .filter(p -> p.getGender() == Person2.Sex.MALE)
    .mapToInt(Person2::getAge)
    .average()
    .getAsDouble();
    System.out.println(average);
}
//The JDK contains many terminal operations (such as average, sum, min, max, and count) that 
//return one value by combining the contents of a stream. These operations are called reduction operations. 
   
}


class Person2 {
    String name;
    LocalDate birthday;
    Sex gender;
    int age;
 public Person2 () {
        this.name = "ABC";
        this.age = 1;
        this.gender = Sex.FEMALE;
    }   
 public Person2 (String name, int age, Sex gender, String emailAddress) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
 
    public enum Sex {
        MALE, FEMALE
    }

    public int  getAge() {
        // ...
        
        return age;
    }
    
    public Sex getGender(){
        return gender;
    }
    
    public void printPerson() {
        // ...
        System.out.println(this.name);
    }
    
    public String  getName() {
        // ...
        
        return name;
    }
    public static List<Person2> createRoster(){
    List<Person2> roster = new ArrayList<Person2>();
     Person2 amy=new Person2("Amy",22,Person2.Sex.FEMALE,"Amy@genetics.ac.cn");
     Person2 john=new Person2("John",22,Person2.Sex.MALE,"john@genetics.ac.cn");
     Person2 Mark=new Person2("Mark",25,Person2.Sex.MALE,"Mark@genetics.ac.cn");
     roster.add(amy);
     roster.add(john);
     roster.add(Mark);
     return roster;
    }
}