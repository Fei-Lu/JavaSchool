/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author xuebo
 */
public interface SortedSetAndMapAndSummary {
    
    public static void test(){
        
        outputHashSet();
        outputTreeSet();
        
        outputSortedSet();
        outputSortedSet2();
        outputSortedSet3();
        
        outputSortedMap();
        outputSortedMap2();
        outputSortedMap3();
        
        outputSummary();
        outputSummary2();
        outputSummary3();
        
    }
   
    
    
    //Collection不能进行双向输出，Set接口与Collection接口定义一致，所以本身也不能双向输出。
    //HashSet：使用散列的方式存放，本身没有顺序，无序指的是存取无序，不是储存数据无序
    public static void outputHashSet(){
        
        Set<String> allSet = new HashSet<String>() ;  
        
        allSet.add("Bbbb") ;   // add  
        allSet.add("Aftr") ;   // add 
        allSet.add("Cdeee") ;   // add 
        allSet.add("C") ;   // repetition 
        allSet.add("C") ;   // repetition 
        allSet.add("E") ;   // add 
        allSet.add("D") ;   // add
        
        System.out.println(allSet) ;  
        
        System.out.println("**********************");
    }
    
    
    //TreeSet类的内容是可以排序的，如果任意给出一个自定义的类，观察能否进行排序操作
    public static void outputTreeSet(){
        Set<String> allSet = new TreeSet<String>() ;  
            allSet.add("A") ;
            allSet.add("B") ;   
            allSet.add("C") ;    
            allSet.add("C") ;    
            allSet.add("C") ;    
            allSet.add("D") ;    
            allSet.add("E") ;   
            
            System.out.println(allSet) ;  
            
            System.out.println("**********************");
            
    }
    
    
    //1、public Comparator<? super E> comparator()  普通 返回与排序有关联的比较器。
    //2、public E first()  普通 返回集合中的第一个元素。
    //3、public SortedSet<E> headSet(E toElement) 普通  返回从开始到指定元素的集合。
    //4、public E last()   普通 返回最后一个元素。
    //5、public SortedSet<E> subSet(E fromElement, E toElement) 普通  返回指定对象间的元素。
    //6、public SortedSet<E> tailSet(E fromElement) 普通  从指定元素到最后。
    public static void outputSortedSet(){
        
        SortedSet<String> allSet = new TreeSet<String>() ;  //   
        allSet.add("A") ;   
        allSet.add("B") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("D") ;   
        allSet.add("E") ;    
        
        System.out.println("第一个元素：" + allSet.first()) ; 
        
        System.out.println("最后一个元素：" + allSet.last()) ; 
        
        System.out.println("headSet元素：" + allSet.headSet("C")) ;  
        
        System.out.println("tailSet元素：" + allSet.tailSet("C")) ;  
        
        System.out.println("subSet元素：" + allSet.subSet("B","D")) ;  
        
        System.out.println("**********************");
        
                
    }
    
    
    
    public static void outputSortedSet2(){
        
        SortedSet<String> allSet = new TreeSet<String>() ;  //   
        allSet.add("A") ;   
        allSet.add("B") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("D") ;   
        allSet.add("E") ;    
        allSet.add("E") ; 
        allSet.add("F") ; 
        allSet.add("G") ; 
        allSet.add("H") ; 
        allSet.add("I") ; 
        allSet.add("J") ; 
        allSet.add("K") ; 
        allSet.add("L") ; 
        
        int count = allSet.subSet("A", "D").size();
        System.out.println(count);
        
        count = allSet.subSet("A", "D\0").size();
        System.out.println(count);
        
        count = allSet.subSet("A\0", "D").size();
        System.out.println(count);
        
        allSet.subSet("A", "D").clear();
        System.out.println(allSet);
        
        for (char ch = 'A'; ch <= 'L'; ) {
        String from = String.valueOf(ch++);
        String to = String.valueOf(ch);
        
        System.out.println(from + ": " + allSet.subSet(from, to).size());
        
        }
        System.out.println("**********************");
        
        
    }
    
    //SortedSet 排序状态   
    //Comparator comparator（）返回当前Set使用的Comparator;或者返回null  
    //SortedSet是按对象的比较函数对无素排序的  
    public static void outputSortedSet3(){  
        
        SortedSet<String> sorted=new TreeSet<String>();  
        Collections.addAll(sorted,"one two three four five six seven eight".split(" "));  
        System.out.println(sorted);  
        
        String low=sorted.first();  
        String high=sorted.last();  
        System.out.println(low);  
        System.out.println(high);  
        Iterator<String> it=sorted.iterator();  
        for(int i=0;i<=6;i++)  
        {  
            if(i==3)low=it.next();  
            if(i==6) high=it.next();  
            else  
                it.next();  
        }  
        System.out.println(low);  
        
        System.out.println(high); 
        
        System.out.println(sorted.subSet(low,high));  
        
        System.out.println(sorted.headSet(high));//小于 ToElement元素的组成 
        
        System.out.println(sorted.tailSet(low));//大于等于  
        
        System.out.println("**********************");
        System.out.println("**********************");
    }  
    
      public static void outputSortedMap(){  
        HashMap<String,String> map=new HashMap<String, String>(); 
        long a = System.nanoTime();
          map.put("3","55");    
          map.put("2", "22");
          map.put("1", "33");    
          for (Entry<String,String> entry: map.entrySet()) {    
          System.out.println("before:"+entry.getKey()+" Value"+entry.getValue());    
              
          }
          long b = System.nanoTime();
          System.out.println(b-a);
          
          System.out.println("===============");    
          SortedMap<String,String> sort=new TreeMap<String,String>(map); 
          long c = System.nanoTime();
          Set<Entry<String,String>> entry1=sort.entrySet();    
          Iterator<Entry<String,String>> it=entry1.iterator();    
          while(it.hasNext())    
          {    
           Entry<String,String> entry=it.next();    
           System.out.println("after:"+entry.getKey()+" Value"+entry.getValue());    
          } 
          
          long d = System.nanoTime();
          System.out.println(d-c);
          
          System.out.println("**********************");
    }   
      
      
    public static void outputSortedMap2() {  
        Map<Double, String> map = new TreeMap<Double, String>(  
                new Comparator<Double>() {  
                    public int compare(Double obj1, Double obj2) {   
                        return obj2.compareTo(obj1);  
                    }  
                });  
                map.put(2.33, "ccccc");  
                map.put(2.0, "aaaaa");  
                map.put(3.0, "bbbbb");  
                map.put(4.0, "ddddd");  
          
        Set<Double> keySet = map.keySet();  
        Iterator<Double> iter = keySet.iterator();  
        while (iter.hasNext()) {  
            Double key = iter.next();  
            System.out.println(key + ":" + map.get(key));  
        } 
        
        System.out.println("**********************");
        
    }  
    
    public static void outputSortedMap3() {
            Map<String, String> map = new TreeMap<String, String>();
            map.put("a", "ddddd");
            map.put("c", "bbbbb");
            map.put("d", "aaaaa");
            map.put("b", "ccccc");
        
        //将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
        public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
        
        for(Map.Entry<String,String> mapping:list){ 
               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
          } 
        System.out.println("**********************");
    }
    
    
    //Question1: At the beginning of this lesson, you learned that the core collection interfaces are organized into two distinct inheritance trees.
    //One interface in particular is not considered to be a true Collection, and therefore sits at the top of its own tree. What is the name of this interface? 
    
    //Question2: Each interface in the collections framework is declared with the <E> syntax, which tells you that it is generic.
    //When you declare a Collection instance, what is the advantage of specifying the type of objects that it will contain? 
    
    //Question3: What interface represents a collection that does not allow duplicate elements? 
    
    //Question4: What interface forms the root of the collections hierarchy? 
    
    //Question5: What interface represents an ordered collection that may contain duplicate elements? 
    
    //Question6: What interface represents a collection that holds elements prior to processing? 
    
    //Question7: What interface repesents a type that maps keys to values? 
    
    //Question8: What interface represents a double-ended queue? 
    
    //Question9: Name three different ways to iterate over the elements of a List.
    
    //Question10: True or False: Aggregate operations are mutative operations that modify the underlying collection.
    
    //Question11:Consider the four core interfaces, Set, List, Queue, and Map. For each of the following four assignments, 
    //specify which of the four core interfaces is best-suited, and explain how to use it to implement the assignment. 
    //11.1:Whimsical Toys Inc (WTI) needs to record the names of all its employees. Every month, an employee will be chosen at random from these records to receive a free toy.
    //11.2:WTI has decided that each new product will be named after an employee — but only first names will be used, and each name will be used only once. Prepare a list of unique first names.
    //11.3:WTI decides that it only wants to use the most popular names for its toys. Count up the number of employees who have each first name.
    //11.4:WTI decides that it only wants to use the most popular names for its toys. Count up the number of employees who have each first name.
   
    
     public static void outputSummary() {
        String[] args = {"aabbddeeffffffffff"} ;
        
        // Get and shuffle the list of arguments
        List<String> argList = Arrays.asList(args);
        Collections.shuffle(argList);
        
        // Print out the elements using JDK 8 Streams
        argList.stream()
        .forEach(e->System.out.format("%s ",e));

        // Print out the elements using for-each
        for (String arg: argList) {
            System.out.format("%s ", arg);
        }

        System.out.println();
        System.out.println("**********************");
    }
    
    public static void outputSummary2()  {
        
        String[] args = {"aabbddeeffffffffff"} ;
        Set<String> s = new HashSet<String>();
        
        for (String a : args)
               s.add(a);
               System.out.println(s.size() + " distinct words: " + s);
        System.out.println("**********************");
    }
    
    static void listTrim(List<String> strings) {
        for (ListIterator<String> lit = strings.listIterator(); lit.hasNext(); ) {
            lit.set(lit.next().trim());
        }
    }

    public static void outputSummary3() {
        List<String> l = Arrays.asList(" red ", " white ", " blue ");
        listTrim(l);
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }
       System.out.println("**********************");
    }
}
