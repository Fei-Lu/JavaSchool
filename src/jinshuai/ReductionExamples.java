/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;
import java.util.ArrayList; 
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.util.function.*;
import java.lang.Double;

/**
 *
 * @author Planck
 */
public class ReductionExamples {
     public static void main(String... args) {
        
        // Create sample data

        List<Person2> roster = Person2.createRoster();
    
        System.out.println("Contents of roster:");
        
        roster
            .stream()
            .forEach(p -> p.printPerson());

        System.out.println();

        // 1. Average age of male members, average operation
        
        double average = roster
            .stream()
            .filter(p -> p.getGender() == Person2.Sex.MALE)
            .mapToInt(Person2::getAge)
            .average()
            .getAsDouble();
            
        System.out.println("Average age (bulk data operations): " +
            average);
        
        // 2. Sum of ages with sum operation
        
        Integer totalAge = roster
            .stream()
            .mapToInt(Person2::getAge)
            .sum();
            
        System.out.println("Sum of ages (sum operation): " +
            totalAge);
        
        // 3. Sum of ages with reduce(identity, accumulator)
        //reduce:T reduce(T identity, BinaryOperator accumulator)
        Integer totalAgeReduce = roster
            .stream()
            .map(Person2::getAge)
            .reduce(
                0,
                (a, b) -> a + b);
            
        System.out.println(
            "Sum of ages with reduce(identity, accumulator): " +
            totalAgeReduce);
         
        // 4. Average of male members with collect operation
        //Unlike the reduce method, which always creates a new value when it processes an element, 
        //the collect method modifies, or mutates, an existing value.
        Averager averageCollect = roster.stream()
            .filter(p -> p.getGender() == Person2.Sex.MALE)
            .map(Person2::getAge)
            .collect(Averager::new, Averager::accept, Averager::combine);
                   
        System.out.println("Average age of male members: " +
            averageCollect.average());
         
        // 5. Names of male members with collect operation
        System.out.println("Names of male members with collect operation: ");         
        List<String> namesOfMaleMembersCollect = roster
            .stream()
            .filter(p -> p.getGender() == Person2.Sex.MALE)
            .map(p -> p.getName())// .map(Person2::getName())
            .collect(Collectors.toList());         

        namesOfMaleMembersCollect
            .stream()
            .forEach(p -> System.out.println(p));
             
        // 6. Group members by gender
         
        System.out.println("Members by gender:");
        Map<Person2.Sex, List<Person2>> byGender =
            roster
                .stream()
                .collect(
                    Collectors.groupingBy(Person2::getGender));
                
        List<Map.Entry<Person2.Sex, List<Person2>>>
            byGenderList = 
            new ArrayList<>(byGender.entrySet());
            
        byGenderList
            .stream()
            .forEach(e -> {
                System.out.println("Gender: " + e.getKey());
                e.getValue()
                    .stream()
                    .map(Person2::getName)
                    .forEach(f -> System.out.println(f)); });
         
        // 7. Group names by gender
         
        System.out.println("Names by gender:");
        Map<Person2.Sex, List<String>> namesByGender =
            roster
                .stream()
                .collect(
                     Collectors.groupingBy(
                         Person2::getGender,                      
                         Collectors.mapping(
                             Person2::getName,
                             Collectors.toList())));
                     
        List<Map.Entry<Person2.Sex, List<String>>>
            namesByGenderList = 
                new ArrayList<>(namesByGender.entrySet());
                     
        namesByGenderList
            .stream()
            .forEach(e -> {
                System.out.println("Gender: " + e.getKey());
                e.getValue()
                    .stream()
                    .forEach(f -> System.out.println(f)); });
         
        // 8. Total age by gender
        
        System.out.println("Total age by gender:");
        Map<Person2.Sex, Integer> totalAgeByGender =
            roster
                .stream()
                .collect(
                     Collectors.groupingBy(
                         Person2::getGender,                      
                         Collectors.reducing(
                             0,
                             Person2::getAge,
                             Integer::sum)));
                
        List<Map.Entry<Person2.Sex, Integer>>
            totalAgeByGenderList = 
            new ArrayList<>(totalAgeByGender.entrySet());
                     
        totalAgeByGenderList
            .stream()
            .forEach(e -> 
                System.out.println("Gender: " + e.getKey() +
                    ", Total Age: " + e.getValue()));
             
        // 9. Average age by gender
         
        System.out.println("Average age by gender:");
        Map<Person2.Sex, Double> averageAgeByGender =
            roster
                .stream()
                .collect(
                     Collectors.groupingBy(
                         Person2::getGender,                      
                         Collectors.averagingInt(Person2::getAge)));
                 
        for (Map.Entry<Person2.Sex, Double> e : averageAgeByGender.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
class Averager implements IntConsumer
{
    private int total = 0;
    private int count = 0;
        
    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }
        
    public void accept(int i) { total += i; count++; }
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}