/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author feilu
 */
public class LambdaExpressionExample {
    
    public static void tests () {
        int size = 100;
        String ss = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        ArrayList<Person> roster = new ArrayList();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(ss.charAt((int)(Math.random()*ss.length()))).append(ss.charAt((int)(Math.random()*ss.length()))).append(ss.charAt((int)(Math.random()*ss.length())));
            String name = sb.toString();
            int age = (int)(Math.random()*100);
            Person.Sex sex = Math.random()>0.5? Person.Sex.MALE : Person.Sex.FEMALE;
            roster.add(new Person (name, age, sex));
        }
        CheckPerson tester = new CheckPersonEligibleForSelectiveService();
        printPersons(roster, tester);
    }
    
    
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
    
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
    
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
        
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        
        printPersons(
            roster,
            new CheckPerson() {
                @Override
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
                }
            }
        );
        
        printPersons(
            roster, 
            (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
    }
    
    
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}

interface CheckPerson {
    boolean test(Person p);
}

class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    int age;
    Sex gender;
    
    public Person (String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.println("Name: " + name + ", Age: " + String.valueOf(age) + ", Gender: " + gender);
    }
    
    public Sex getGender() {
        return gender;
    }
}