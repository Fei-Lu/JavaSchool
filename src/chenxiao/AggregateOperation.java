/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 *
 * @author cauxu
 */
public class AggregateOperation {
    public static void main(String... args){
        List<Person> roster=creatRoster();
        
        printName(roster);
        printMaleName(roster);
        printAverageAgeofMales(roster);
        
        //reduce
        printTotalAge(roster);
        //collect
        printAverageCollection(roster);
        printNamesofMaleMembers(roster);
        groupNamesbyGender(roster);
        
        
    }
    
    /*
        pipeline contains:
        A sourse
        Zero or more intermediate operations return a new stream
        A terminal operation produce non-stream result
    
        Differences Between Aggregate Operations and Iterators:tutorials
        */
    
    public static List<Person> creatRoster(){
            List<Person> roster=new ArrayList<>();
            int size=5;
            for(int i=0;i<size;i++){
                String st="ABCDEFGHIGKLMNOPQRSTUVWXYZ";
                StringBuilder sb=new StringBuilder();
                sb.append(st.charAt((int)(Math.random()*st.length()))).append(st.charAt((int)(Math.random()*st.length()))).append(st.charAt((int)(Math.random()*st.length()))).append(st.charAt((int)(Math.random()*st.length())));
                String name=sb.toString();
                int age=(int)(Math.random()*50);
                System.out.println(age);
                Person.Sex sex=Math.random()>0.5?Person.Sex.MALE:Person.Sex.FEMALE;
                String email=name+"@genetics.ac.cn";
                Person person=new Person(name,age,sex,email);
                roster.add(person);
            }
            return roster;
        }
    
    public static void printName(List<Person> ls){
        for (Person p : ls) {
        System.out.println("Names in the roster: "+p.getName());
        }
        System.out.println("**************************");
        ls.stream().forEach(e -> System.out.println("Names in the roster: "+e.getName()));//对集合中的每一项进行某种操作
        System.out.println();
        /*
        class consumer implements Consumer{
        void accept(Person p){
            System.out.println(.getName);
        }
        }
        ls.stream().foreach(new consumer);
        */
    }
    
    public static void printMaleName(List<Person> ls){
        for (Person p : ls) {
        if (p.getGender() == Person.Sex.MALE) {
        System.out.println("Male names in the roster: "+p.getName());
            }
        }
        System.out.println("**************************");
        ls.stream().filter(e -> e.getGender() == Person.Sex.MALE).forEach(e -> System.out.println("Male names in the roster: "+e.getName()));//filter 返回一个符合条件的stream
        System.out.println();
    }
    
    public static void printAverageAgeofMales(List<Person> ls){
        double average = ls.stream().filter(p -> p.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("Average Age of Males: "+average);  
        System.out.println();
        }
    
    //reduce 
    public static void printTotalAge(List<Person> ls){
        Integer totalAge = ls.stream().mapToInt(e -> e.getAge()).sum();
        Integer totalAgeReduce = ls.stream().map(Person::getAge).reduce(0,(a, b) -> a + b);
        System.out.println("Total age: "+totalAge);      
        System.out.println("Total age recuce: "+totalAgeReduce); 
        System.out.println();
    }
    
    //collect:mutable reduction
    public static void printAverageCollection(List<Person> ls){
        Averager averageCollect = ls.stream()
        .filter(p -> p.getGender() == Person.Sex.MALE)
        .map(Person::getAge)
        .collect(Averager::new, Averager::accept, Averager::combine);             
        System.out.println("Average age of male members: " +averageCollect.average());
    }
    
    public static void printNamesofMaleMembers(List<Person> ls){
        List<String> namesOfMaleMembersCollect = ls
        .stream()
        .filter(p -> p.getGender() == Person.Sex.MALE)
        .map(p -> p.getName())
        .collect(Collectors.toList());
        namesOfMaleMembersCollect.stream().forEach(p -> System.out.println("Names of male members: "+p));        
    }
    
    public static void groupNamesbyGender(List<Person> ls){
        Map<Person.Sex, List<String>> namesByGender =ls.stream().collect(
                Collectors.groupingBy(
                        Person::getGender,Collectors.mapping(
                                Person::getName,Collectors.toList())));
        List<Map.Entry<Person.Sex, List<String>>> namesByGenderList = 
                new ArrayList<>(namesByGender.entrySet());
                      
        namesByGenderList.stream().forEach(e -> {
                System.out.println("Gender: " + e.getKey());
                e.getValue().stream().forEach(f -> System.out.println("Group names by gender: "+f)); });
    } 
}

class Averager implements IntConsumer{
    private int total = 0;
    private int count = 0;
        
    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }
        
    @Override
    public void accept(int i) { 
        total += i; 
        count++; 
    }
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}

class Person1{
    public enum Sex {
        MALE, FEMALE
    }
    String name;
    int age;
    Sex gender;
    String email;
    public Person1(String name,int age,Sex gender,String email){
        this.age=age;
        this.gender=gender;
        this.name=name;
        this.email=email;
    }
    public int getAge(){
        return this.age;
    }
    public Sex getGender(){
        return this.gender;
    }
    public String getName(){
        return this.name;
    }
    public void printPerson(){
        System.out.println(this.name+" "+this.age+" "+this.gender+" "+this.email);
    }
}


