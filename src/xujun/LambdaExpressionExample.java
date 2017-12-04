/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xujun;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author feilu
 */
public class LambdaExpressionExample {
    
    public static List<Person> createRoster () {
//<>里面是数据类型 List是有顺序的collection的一个集合 而像set是非冗余的
        int size = 100;
        String ss = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        List<Person> roster = new ArrayList();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
 //StringBuilder和String的区别：String相加是创建第三个对象 多个线程可以同时访问，没有上锁，会占用很多内存 
 //StringBuilder是将String类型的数据在一个对象里进行相加，速度很快不占用内存
            sb.append(ss.charAt((int)(Math.random()*ss.length()))).append(ss.charAt((int)(Math.random()*ss.length()))).append(ss.charAt((int)(Math.random()*ss.length())));
 //append就是加上；random() Returns a double value with a positive sign（正数）, greater than or equal to 0.0 and less than 1.0.
            String name = sb.toString();
            int age = (int)(Math.random()*100);
            Person.Sex sex = Math.random()>0.5? Person.Sex.MALE : Person.Sex.FEMALE;
            roster.add(new Person (name, age, sex, name+"@gmail.com"));
        }
        return roster;
    }
 //创建了一个list 里面的Person编号从0到88   
    public static void tests () {
//进入方法体的途径：按住ctrl键并点击方法
        List<Person> roster = LambdaExpressionExample.createRoster();

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
    //parallelStream将单线程变成了多线程
    public static void processPersionsWithAgregateFunction (List<Person> roster) {
        roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
        .map(p -> p.getEmailAddress())
        .forEach(email -> System.out.println(email));
    }
    //lambda表达式的最终表达方式 roster（任何collection类型）.stream形成流 .filter进行过滤（符合条件的过滤出来） .map通过括号里的条件得到一个值 .forEach对....进行操作
    
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
 //email包括p都是对象的名字，是自定义的没有严格要求的。   
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
//这个方法里面定义了四个参数，后面的三个都是通过接口创建了对象 “Interface Function<T,R> T（input）R（result）作用Applies this function to the given argument
// Interface Consume，里面的一个方法accept(T t），就是对所给的参数执行这个操作（接受这个参数）。
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
    //挑出符合这个条件的person并输出
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
    
    public static void printPersons(List<Person> roster, CheckPerson tester) {
    //CheckPerson是一个接口 CheckPerson里面有一个test的方法 这里是建立了一个tester的对象 判断这个对象是否属于list并且输出。
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
    //匿名类的表示方式 因为printPersons里面用接口创建了一个对象所以可以直接用匿名类new一个对象 也可以直接用printPersons里的test方法
    //the syntax of anonymous classes is bulky considering that the CheckPerson interface contains only one method.（CheckPerson中只能有一个方法）
    public static void printPersonsWithLambdaExpression (List<Person> roster) {
        printPersons(
            roster, 
            (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
    }
    //这个与匿名类表示的方法是一样的（）里面是对象->指向条件
    public static void printPersonsWithPredicateImpl(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    //点击Predicate(断言 判断）跳转到FunctionInterface “Interface Predicate<T> T - the type of the input to the predicate”
    //也是用接口创建了一个对象 tester 在这个接口里面也是有一个test的方法 来Evaluates this predicate on the given argument（评估给定的参数）输出的为boolean类型
    
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
//The CheckPerson interface is a functional interface
//A functional interface is any interface that contains only one abstract method.(A functional interface may contain one or more default methods or static methods.) 
// Because a functional interface contains only one abstract method, you can omit the name of that method when you implement it. 
//To do this, instead of using an anonymous class expression, you use a lambda expression, which is highlighted in the following method invocation:
class Person {

    public enum Sex {
        MALE, FEMALE
    }
//enum枚举类型 对一个类进行提前定义 调用的时候只能选择其中的一个选项
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
    
    public String getName () {
        return name;
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
    
    public static int compareByAge (Person a, Person b) {
        return a.getAge() - b.getAge();
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
/*两个参数lambda表达式的书写方式（->条件或者函数的输出语句）
     Consumer<Integer> myConsumer = (x) -> {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
    };   */
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));    
    }
}

class LambdaScopeTest {

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
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
            };

            myConsumer.accept(x);
//（y）-（x) The compiler generates the error "variable x is already defined in method methodInFirstLevel(int)" 
//because the lambda expression does not introduce a new level of scoping. 
        }
    }
}