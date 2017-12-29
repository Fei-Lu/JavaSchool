/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

/**
 *
 * @author cauxu
 */
public class LambdaExpression {
    public static void main(String... args){
        Sum sum =(Person p) -> {
            for(int i=0;i<100;i++){
                p.age+=(int)Math.random()*10;
            }
            return p.age;
        };  //当在使用某abstract类或接口切无须对其进行改变的时，可直接创建实现类和对象即匿名类
        //lamnda表达式
        printout((Person p) -> p.age+=(int)Math.random()*10);

        IntegerMath mt1= (a , b) -> a+b;//lambda expression必须时可被return 出结果的语句组合
        operatBinary((a,b) -> a*a+b);
        
        
        
        List<Person> roster=creatRoster();
        printPersons(roster, new CheckPersonEligibleForSelectiveService());//实现checkperoson接口的类
        printPersons(roster,new CheckPerson() {
        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25;
        }
    }
        );//直接创建checkPerson接口的匿名类
        
        //lambda expression 
        printPersons(roster,(Person p) -> p.getGender() == Person.Sex.MALE&& p.getAge() >= 18&& p.getAge() <= 25);//直接重写并调用checkperson里的唯一的方法 checkperson作为方法的参数
        processPersons(roster,(Person p) -> p.getGender() == Person.Sex.MALE&& p.getAge() >= 18&& p.getAge() <= 25,(Person p)->System.out.println(p));
        
    }
    public static List<Person> creatRoster(){
            List<Person> roster=new ArrayList<>();
            int size=50;
            for(int i=0;i<size;i++){
                String st="ABCDEFGHIGKLMNOPQRSTUVWXYZ";
                StringBuilder sb=new StringBuilder();
                sb.append(st.charAt((int)(Math.random()*st.length()))).append(st.charAt((int)(Math.random()*st.length()))).append(st.charAt((int)(Math.random()*st.length()))).append(st.charAt((int)(Math.random()*st.length())));
                String name=sb.toString();
                int age=(int)Math.random()*50;
                Person.Sex sex=Math.random()>0.5?Person.Sex.MALE:Person.Sex.FEMALE;
                String email=name+"@genetics.ac.cn";
                Person person=new Person(name,age,sex,email);
                roster.add(person);
            }
            return roster;
        }
    
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
            p.printPerson();
            }
        }  
}
    public static void printPersonsWithinAgeRange(
        List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }
    public static void printPersons(
        List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
}
    
    public static void processPersons(List<Person> roster,Predicate<Person> tester,Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }
    
    public static void processPersionsWithAgregateFunction (List<Person> roster){
        roster.stream().filter(p -> p.age>25 && p.age<50).map(p -> p.getName()).toArray();
    }
    
    
    
    public static void printout(Sum s){
        System.out.println(s);
    }
    
    public static int operatBinary(IntegerMath m){
        int a=3;
        int b=4;
        int s=0;
        for(int i=0;i<100;i++){
            s+=m.Operation(a, b);
        }
        return s;
    }
}

interface IntegerMath{
    int Operation(int a,int b);
}

interface Sum{
    public int sumerize(Person p);
}

class Person{
    public enum Sex {
        MALE, FEMALE
    }
    String name;
    int age;
    Sex gender;
    String email;
    public Person(String name,int age,Sex gender,String email){
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
    public String getEmail(){
        return this.email;
    }
    public void printPerson(){
        System.out.println(this.name+" "+this.age+" "+this.gender+" "+this.email);
    }
}

interface CheckPerson {
    boolean test(Person p);
}
class CheckPersonEligibleForSelectiveService implements CheckPerson {
    @Override
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}
