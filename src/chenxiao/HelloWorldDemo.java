/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;
//import Yao.Tree;
//import Yao.PineApple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author cauxu
 */

public class HelloWorldDemo {
    public static void main(String[] args){
        List list=new ArrayList();
        list.add("xue");//没有使用泛型的List里默认存储Object对象
        String name=(String)list.get(0);//cast
        System.out.println(name);
        
        List<String> listg=new ArrayList<>();//以List接口 实例化对象，只能调用List接口中定义的方法
        listg.add("xue");
        //list.add(0);
        String name2=listg.get(0);
        System.out.println(name2);
        //System.out.println(listg.get(1));
   
        
        //引用和实例化泛型类型
        Box<Integer> integerG=new Box<Integer>();//在<>中放入想要的类、接口。。。 type argument VS type parameter 黄色下划线
        integerG.setT(1);
        System.out.println(integerG.getT());
        
        //raw types
        Box rawBox=new Box();
        Box<String> stringBox = new Box<>();
        rawBox = stringBox;        
        rawBox.setT(8);//仍然没有报异常啊！
        System.out.println(rawBox.getT());
        Box<Integer> intBox = rawBox; //为什么没有提示！？
        
        
        //Generic Method、多个类型参数
        Pair<String, String> p1 = new OrderedPair<>("Even","xue");
        Pair<String, Integer>  p2 = new OrderedPair<>("hello", 8);
        OrderedPair<String, Box<Integer>> op1= new OrderedPair<>("primes", integerG);//String 自动 拆箱 new Box<> Box 对象 Parameterized Types 作为type argument
        System.out.println(OrderedPair.compare(p1,p2));//invoking generic method
        
        //Bounded Type Parameters
        Box<Integer> integerBox = new Box<>();
        integerBox.setT(new Integer(10));
        //integerBox.inspect("some text"); // error: this is still String!
        integerBox.inspect(13);  
        
        //Generics, Inheritance, and Subtypes subtypes 教程s
        Box<Number> NumberBox=new Box<>();
        System.out.println(NumberBox.add(3,2));//
        
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String>  ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
        
        //Wildcards and subtypes
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number>  numList = intList; 
        //intList.add(ls);
        //OrderedPair<String, Box<Number>> op2 = new OrderedPair<>("primes", integerG);
        List<EvenNumber> le = new ArrayList<>();
        List<? extends NaturalNumber> ln = le;//read-only
        //ln.add(new NaturalNumber(35));
        //ln.add(new EvenNumber(35)); 
    }
    
    //upper bounded wildcards
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
    //unbounded wildcards
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    //lower bounder wildcards
    public static void addNumbers(List<? super Integer> list) {//How to invoke it?
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
    
    //Wildcard Capture and Helper Methods
public class WildcardError {
    /*void foo(List<?> i) { 
        i.set(0, i.get(0));
        }
    }*/
    void foo(List<?> i) {
        fooHelper(i);
    }
    private <T> void fooHelper(List<T> l) {
        T t;
        t=l.get(0);
        l.set(0, l.get(0));
    }
    /*void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
      Number temp = l1.get(0);
      l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
                            // got a CAP#2 extends Number;
                            // same bound, but different types
      l2.set(0, temp);	    // expected a CAP#1 extends Number,
                            // got a Number
    }*/
    //There is no helper method to work around the problem, because the code is fundamentally wrong.
}
    
//Generic Methods and Bounded Type Parameters
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {//创建泛型数组？？？
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
         return count;
    }
    
}

interface Comparable<T> {
    public int compareTo(T o);
}


        
        
        
        
        
        
        
/*class Person {
    private int age;
    private String name;
    public Person(int a){
        this.age=a;
    }
    Person(int b,String nm){
        this(b);
        this.name=nm;
    }
    public boolean equalsTo(int a){
        boolean SameAge=this.age==a;
        System.out.println(SameAge);
        return SameAge;
    }
}    
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        System.out.println(myAnimal == myCat);
        Animal.testClassMethod();
        Cat.testClassMethod();
        Animal myCat2=new Cat();
        myCat2.testInstanceMethod();
        myAnimal.testInstanceMethod();//override 父类中的方法被重写，再次调用父类的该方法为重写后的方法，hide static 仅覆盖父类方法，即调用的仍是父类中的原方法
        
        Tree a=new Tree(1973,2,45,"green","dfdf");
        PineApple b=new PineApple(2,23,2,"green","dfv");
        Person p1=new Person(22);
        p1.equalsTo(22);
        String s="myname";
        s="xuechenxiao";
        System.out.println(s);
        
        ShadowClass sc=new ShadowClass();
        ShadowClass.staticclass ic=new ShadowClass.staticclass();//static nested class 可通过outerclass直接创建对象，
                                                                //但inner class需通过实现一个outclass的对象来创建其对象
        sc.toOuterClassValue();
        ic.toValue();
        System.out.println(Integer.TYPE);
    }
    public Integer integerTest(String a){
        Integer s=new Integer(a);
        Integer t=4;
        return s;
    }*/

