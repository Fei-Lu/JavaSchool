/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;
import java.util.function.Predicate;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author 靳帅
 */
interface CheckPerson {  
    boolean test(Person p);  
    
} 

//Person Class
    public class Person  {
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;
 public Person (String name, int age, Sex gender, String emailAddress) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }
    public enum Sex {
        MALE, FEMALE
    }

    

    public int  getAge() {
        // ...
        int Age=1;
        return Age;
    }
    public Sex getGender(){
        return gender;
    }
    public void printPerson() {
        // ...
    }
//最简单也最不稳定
    public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
        if (p.getAge() >= age) {
            p.printPerson();
        }
    }
}
//创建一个搜索具有多个特性的成员的方法
    public static void printPersonsWithinAgeRange(
    List<Person> roster, int low, int high) {
    for (Person p : roster) {
        if (low <= p.getAge() && p.getAge() < high) {
            p.printPerson();
        }
    }
}
//内部类
    public static void printPersons(  
    List<Person> roster, CheckPerson tester) {  
    for (Person p : roster) {  
        if (tester.test(p)) {  
            p.printPerson();  
        }  
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
//匿名类
     public static void AnprintPerson (List<Person> roster) {
        printPersons(
            roster,
            new CheckPerson() {
                @Override
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE 
                            && p.getAge() >= 18 
                            && p.getAge() <= 25;
                }
            }
        );
    }
//Lambda 表达式
      public static void laprintPerson (List<Person> roster) {
        printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE 
                && p.getAge() >= 18
                && p.getAge() <= 25);
    }
//使用泛型
public static void printPersonsWithPredicate(  
    List<Person> roster, Predicate<Person> tester) {  
    for (Person p : roster) {  
        if (tester.test(p)) {  
            p.printPerson();  
        }  
    }  
}        
}
