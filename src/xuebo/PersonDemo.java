/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Xuebo Zhao
 */
public class PersonDemo {
    
    public static void tests () {
        int size = 100;
        String ss = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        List<Person> roster = new ArrayList();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(ss.charAt((int)(Math.random()*ss.length()))).append(ss.charAt((int)(Math.random()*ss.length()))).append(ss.charAt((int)(Math.random()*ss.length())));
            String name = sb.toString();
            int age = (int)(Math.random()*100);
            Person.Sex sex = Math.random()>0.5? Person.Sex.MALE : Person.Sex.FEMALE;
            roster.add(new Person (name, age, sex, name+"@gmail.com"));
        }

        printPersonsOlderThan (roster, 30);
        
        printPersonsWithinAgeRange (roster, 20, 30);
        
        printPersons(roster, new CheckPersonEligibleForSelectiveService());

        printPersonsWithAnonymousClass (roster);
        
        printPersonsWithLambdaExpression (roster);
        
        printPersonsWithPredicateImpl(roster, new CheckPersonUtilFunctionForSelectiveService());

        printPersonsWithPredicateFunction (roster);
        
        processPersionsWithTwoFunction (roster);
        
        processPersionsWithThreeFunction (roster);
        
        processPersionsWithAgregateFunction (roster);
        
        processPersionsWithAgregateFunctionMultiThreads (roster);
        
        testCalculator ();
        
        testScope ();
    }
    
    public static void testScope () {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
    
    public static void testCalculator () {
        LambdaCalculator myApp = new LambdaCalculator();
        LambdaCalculator.IntegerMath addition = (a, b) -> a + b;
        LambdaCalculator.IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
    }
    
    public static void processPersionsWithAgregateFunctionMultiThreads (List<Person> roster) {
        roster.parallelStream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
        .map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
    }
    
    public static void processPersionsWithAgregateFunction (List<Person> roster) {
        roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
        .map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
    }
    
    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    
    public static void processPersionsWithThreeFunction (List<Person> roster) {
        processPersonsWithFunction(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );
    }
    
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    
    public static void processPersionsWithTwoFunction (List<Person> roster) {
        processPersons(
            roster,
            p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25,
            p -> p.printPerson()
       );
    }
    
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
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
    }
    
    public static void printPersonsWithAnonymousClass (List<Person> roster) {
        printPersons(
            roster,
            new CheckPerson() {
                @Override
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
                }
            }
        );
    }
    
    public static void printPersonsWithLambdaExpression (List<Person> roster) {
        printPersons(
            roster, 
            (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
    }
    
    public static void printPersonsWithPredicateImpl(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    
    public static void printPersonsWithPredicateFunction (List<Person> roster) {
        printPersonsWithPredicateImpl (roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        //Why does the following work?
//        printPersons (roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }
}

class CheckPersonUtilFunctionForSelectiveService implements Predicate<Person> {

    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }

}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
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
    String emailAddress;
    
    public Person (String name, int age, Sex gender, String emailAddress) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailAddress = emailAddress;
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
    
    public String getEmailAddress () {
        return this.emailAddress;
    }
}

class LambdaCalculator {
    interface IntegerMath {
        int operation(int a, int b);   
    }
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    public static void main(String... args) {
    
        LambdaCalculator myApp = new LambdaCalculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));    
    }
}

class LambdaScopeClass {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            
            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;
            
            Consumer<Integer> myConsumer = (y) -> 
            {
                System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeClass.this.x = " + LambdaScopeClass.this.x);
            };

            myConsumer.accept(x);

        }
    }
}